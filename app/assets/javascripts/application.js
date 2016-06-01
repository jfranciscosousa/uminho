// This is a manifest file that'll be compiled into application.js, which will include all the files
// listed below.
//
// Any JavaScript/Coffee file within this directory, lib/assets/javascripts, vendor/assets/javascripts,
// or any plugin's vendor/assets/javascripts directory can be referenced here using a relative path.
//
// It's not advisable to add code directly here, but if you do, it'll appear at the bottom of the
// compiled file.
//
// Read Sprockets README (https://github.com/rails/sprockets#sprockets-directives) for details
// about supported directives.
//
//= require jquery
//= require jquery_ujs
//= require dataTables/jquery.dataTables
//= require dataTables/bootstrap/3/jquery.dataTables.bootstrap
//= require twitter/bootstrap
//= require turbolinks
//= require_tree .

$(function() {
    $('[data-toggle="tooltip"]').tooltip()
})

function addFlashMessage(message, type) {
    console.log(message);
    $('#flashMsg').html(
        "<div class=\"flash alert alert-" + type + " fade in\">" +
        "<button class=\"close\" data-dismiss=\"alert\">×</button>" +
        message + "</div>");
    $('#flashMsg').show();
}

function addTabID(url, id) {
  if (url.indexOf("#") >= 0){
    var pos = url.indexOf("#");
    var res = url.replace(url.substr(pos,url.length-pos), id);
    console.log("REPLACING");
    console.log(res);
    return res;
  }
  var res = url.concat(id);
  return res;
}

function getTab(option) {
  switch (option) {
    case "summary":
      return "tab1";
    case "reviews":
      return "tab2";
    case "media":
      return "tab3";
    case "stats":
      return "tab4";
  }

}
