let id = [];
let current_place = "";
let url = "http://localhost:8080/admin/all"
$(document).ready(function(){
    console.log("admin url");

    $.getJSON(url, function(data){
        var items = [];
        $.each( data, function( key, val ) {
            id.push(val.id);
            items.push(

                "<tr id='" + val.id + "'> " +
                "<td>" +val.userName+"</td>"+
                "<td>" +val.password+"</td>"+
                "<td>" +val.roles.split("_")[1]+"</td>"+


                +"</th></tr>" );
        });

        $( "<tbody/>", {
            "class": "my-new-list",
            html: items.join( "" )
        }).appendTo( "table" );

        console.log(data);

    });
});

//Add User
$("#adduser").click(function(e) {
    e.preventDefault();

    // console.log(checks)
        if ($("#username").val().length != 0 && $("#password").val().length != 0){

            $.ajax({
                async:true,
                type: "POST",
                url: "/admin/adduser/",
                data:"username="+$("#username").val()+"&password="+$("#password").val(),
                beforeSend:function(result) {

                    $(".loader").removeClass('d-none');
                },
                success: function(result) {
                    // alert('Multiple update Is done');
                    location.reload(true);
                    $(".loader").addClass('d-none');
                },
                error: function(result) {
                    alert('error');
                }
            });
    }
    else {
        alert("Both of the fields should be filled");
    }

});

//delete User
$("#delete").click(function(e) {
    e.preventDefault();

    if ($("#deleteuser").val().length != 0){

        $.ajax({
            async:true,
            type: "DELETE",
            url: "/admin/deleteuser/",
            data:"username="+$("#deleteuser").val(),
            beforeSend:function(result) {

                $(".loader").removeClass('d-none');
            },
            success: function(result) {
                // alert('Multiple update Is done');
                location.reload(true);
                $(".loader").addClass('d-none');
            },
            error: function(result) {
                alert('error');
            }
        });
    }
    else {
        alert("Insert user to delete");
    }

});