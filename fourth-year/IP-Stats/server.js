var snmp = require("net-snmp");
var compress = require('compression');
var express = require('express');
var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);
var args = process.argv.slice(2);

// web server

var port = args[0];
if (port == undefined) {
  console.log("ERROR! please specify a port");
  process.exit();
}

//enables http compression
app.use(compress());
//set the static folders
app.use('/css', express.static(__dirname + '/pages/css'));
app.use('/js', express.static(__dirname + '/pages/js'));
app.use('/fonts', express.static(__dirname + '/pages/fonts'));
//set the index page
app.get('/', function(req, res) {
  res.sendFile('pages/index.html', {
    root: __dirname
  });
});
//specify port and address to which the HTTP server will bind to
server.listen(port, function() {
  console.log('listening on *:' + port);
});

//snmp sessions, these are basically SNMP connection informations, reused
//each time a snmp primitive is sent to a snmp manager
//these are stored in a key value object, like this -> session[IP]
var snmp_sessions = {};

//received and sent packets OIDs
var oids = ["1.3.6.1.2.1.4.31.1.1.3.1", "1.3.6.1.2.1.4.31.1.1.30.1"];

//handler for connection event
io.on('connection', function(socket) {

  //handler for request-session event
  socket.on('request-session', function(data) {
    //the data object should have one value named ip, we access it like this: data.ip

    // default snmp options, using snmp v2c
    var options = {
      port: 161,
      retries: 1,
      timeout: 2500,
      transport: "udp4",
      trapPort: 162,
      version: snmp.Version2c
    };

    //split the string to get the ip and port
    var aux = data.ip.split(":");
    console.log(aux);
    var ip = aux[0],
      port = aux[1];
    //the port can be undefined, if its not specified, we use the default 161
    if (port)
      options.port = port;
    console.log("new session request on: " + data.ip);

    //if a snmp session is already saved
    if (snmp_sessions[data.ip]) {
      console.log("session exist, reusing");
      //notify the client that the session is stored/reused
      socket.emit('response-session', {});
    } //if not, we create a new one
    else {
      console.log("creating new session");
      var msg;
      //using the 'public' community string
      var session = snmp.createSession(ip, "public", options);
      console.log("new snmp session on: " + data.ip)
        //save our session
      snmp_sessions[data.ip] = session;
      //notify the client that the session is stored/reused
      socket.emit('response-session', {});
    }

    /*
      Remember!! We cannot verify that a SNMP agent exists in a given IP
      by only using the snmp.createSession function, this only stores and reuses
      existing connection parameters, mamybe later we can test an snmp request to
      confirm the existence of a snmp agent
    */
  });

  //handler for request-stats event
  socket.on('request-stats', function(data) {

    //define variables
    var received = -1,
      sent = -1,
      err;

    //if a snmp session is stored
    if (snmp_sessions[data.ip]) {

      /*
        We use our session to get our received and sent packets, using the OIDs
        stored above (around line 33). Remember that the function passed as a parameter
        is a callback, its executed at the end of the session.get function, its how
        nodeJS works, async.
      */
      snmp_sessions[data.ip].get(oids, function(error, varbinds) {
        //if an error exists, we send it back to the client
        if (error) {
          err = error.toString();
        } else {
          // for version 2c we must check each OID for an error condition
          if (snmp.isVarbindError(varbinds[0]))
            err = snmp.varbindError(varbinds[0]);
          else {
            //no error means we are good
            received = varbinds[0].value;
          }
          if (snmp.isVarbindError(varbinds[1]))
            err = snmp.varbindError(varbinds[1]);
          else {
            //same, no error = good
            sent = varbinds[1].value;
          }
        }
        //send our received and sent packets statistics, and the error variables
        //error will be undefined / null if it doesn't exist
        socket.emit('response-stats', {
          received: received,
          sent: sent,
          errors: err
        });
      });
    } else {
      //session doesn't exist, this should never happen, our client-side JS always
      //requests a session before requesting stats but completion is always good! :)
      err = "Session not found";
      socket.emit('response-stats', {
        received: received,
        sent: sent,
        errors: err
      });
    }
  });
});
