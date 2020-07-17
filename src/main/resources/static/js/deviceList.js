let id = [];
$(document).ready(function(){
    $.getJSON("http://localhost:8080/api/all", function(data){
        var items = [];
        $.each( data, function( key, val ) {
            id.push(val.id);
            items.push(

                "<tr id='" + val.id + "'> " +
                "<td><input type='checkbox' id='"+val.id+"' value='"+val.id+"'/></td>"+
                "<th scope='row' >" + val.id +
                "<td>" +val.phoneNumber+"</td>"+
                "<td>" +val.currentStatus+"</td>"+
                "<td>" +val.responseMsg+"</td>"+
                "<td>" +val.registerTime+"</td>"+
                "<td>" +val.lastUpdate+"</td>"+

                +"</th></tr>" );
        });

        $( "<tbody/>", {
            "class": "my-new-list",
            html: items.join( "" )
        }).appendTo( "table" );

        // console.log(data);
    });


});

let validateForm = function() {
    let checks = $('input[type="checkbox"]:checked').map(function() {
        return $(this).val();
    }).get()
    // console.log('submit button clicked');
    if ($('#allDevices').is(":checked")){
        checks.shift();
    }
    // console.log(checks);

    return checks;
}

$("#submit").click(function(e) {
    e.preventDefault();

    let checks = validateForm();
    // console.log(checks)
    if ( checks.length > 0){
        if ($("#rspnsmsgtp").val() != "NOTHING"){
            $.ajax({
                async:true,
                type: "POST",
                url: "/api/mltpl/",
                data:"deviceIds="+checks.toString()+"&msg="+$("#rspnsmsgtp").val(),
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
        }else{
            alert("Choose respond MSG");
        }
    }
    else {
        alert("Select at least one Device");
    }

});

let checkAllDevices = function(){
    if ($('#allDevices').is(":checked")){
        // id.forEach(device => console.log(device));
        $('input:checkbox').attr('checked','checked');
    }else{
        $('input:checkbox').removeAttr('checked');
        // console.log("Uncheck all");
    }
}



// Scroll top



//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}