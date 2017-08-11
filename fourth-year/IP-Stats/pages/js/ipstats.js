$(function() {
  var socket = io();
  var error = false;
  var pollingTime = 60; //intervalo de tempo entre pedidos snmp
  var $received = $('.received');
  var $sent = $('.sent');
  var $message = $('#errorMsg');
  var _received = 0;
  var _sent = 0;
  var receivedAverage = 0;
  var sentAverage = 0;
  var _receivedArr = [];
  var _sentArr = [];
  var aux = 0;
  var dateOffset = new Date().getTimezoneOffset() * 60000;
  var _dataset = [{
    label: "Received Packets",
    data: _receivedArr
  }, {
    label: "Sent Packets",
    data: _sentArr
  }];;
  var starting = true;

  var options = {
    series: {
      shadowSize: 0 // Drawing is faster without shadows
    },
    yaxis: {
      min: 0,
      max: 1000,
    },
    xaxis: {
      mode: 'time',

    }
  }
  var pollingTask;


  $("#button").click(function() {
    var $ip = $("#ipaddr").val();
    socket.emit('request-session', {
      ip: $ip
    });
    //reset existing stats
    var _receivedArr = [];
    var _sentArr = [];
    //hide statistics
    $("#graph").hide();

    socket.on('response-session', function(data) {

      //ask for stats right away, and create a polling task
      socket.emit('request-stats', {
        ip: $ip
      });

      //if a polling task exists, destroy it
      if (pollingTask)
        clearInterval(pollingTask);

      //create new polling task
      pollingTask = setInterval(function() {
        socket.emit('request-stats', {
          ip: $ip
        });
      }, pollingTime * 1000);

      socket.on('response-stats', function(data) {

        if (data.errors) {
          $message.text(data.errors);
          console.log(data.errors);
          $("#graph").hide();
          error = true;
        } else {

          if (_received != 0 && _sent != 0) {
            //newstats - oldstats * 60 / pollingTime
            receivedAverage = (Math.abs(data.received - _received) * 60) / pollingTime;
            sentAverage = (Math.abs(data.sent - _sent) * 60) / pollingTime;
          }

          var date = Date.now() - dateOffset;
          _receivedArr.push([date, receivedAverage]);
          _sentArr.push([date, sentAverage]);
          _dataset = [{
            label: "Received Packets",
            data: _receivedArr
          }, {
            label: "Sent Packets",
            data: _sentArr
          }];
          $received.text("Received IPv4 packets per minute:" + receivedAverage);
          $sent.text("Sent IPv4 packets per minute:" + sentAverage);
          update();

          _received = data.received;
          _sent = data.sent;

          if (starting) {
            $message.text("Receiving stats...");
            starting = false;
            var plot = $.plot("#placeholder", _dataset, options);
            $("#graph").show();
          }
          //if the page was in error state, reset everything
          if (error = true) {
            $("#graph").show();
          }
        };
      });
    });
  });


  function update() {
    var newMax = Math.max(receivedAverage, sentAverage);
    if (newMax > options.yaxis.max)
      options.yaxis.max = newMax;
    $.plot($("#placeholder"), _dataset, options);
  }

  $(document).ready(function() {
    $('#ipaddr').keypress(function(e) {
      if (e.keyCode == 13)
        $('#button').click();
    });
  });
});
