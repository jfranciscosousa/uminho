var _id;

function promoteUserModal(id) {
    $('#myModal').modal('show');
    _id = id;
}

function promoteUserAction() {
    role = $("#formRole option:selected").text();
    console.log(role);
    console.log(_id);
    $.ajax({
        type: "POST",
        url: "/users/" + _id + "/promote",
        data: {
            role: role.toLowerCase()
        },
        success: function(data) {
            console.log(data)
            addFlashMessage(data.message, 'success');
            $("#role" + _id).text(role);
            $('#myModal').modal('hide');
        },
        error: function(data) {
          console.log(data)
            addFlashMessage(data.message, 'error');
            $('#myModal').modal('hide');
        }
    });
}
