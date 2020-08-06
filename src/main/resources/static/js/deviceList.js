//filtering starts
let id = [];
let current_place = "";
let url = "http://localhost:8080/api/"
$(document).ready(function(){
   current_place = window.location.href.split('/')[3];
    console.log(current_place);


    if (current_place === "devices"){
        url = url+"all/"
    }
    else if(current_place === "activedevices"){
        url = url+"status?status=MSGACT";
    }
    else if(current_place === "passivedevices"){
        url = url+"status?status=MSGPSV";
    }
    else if(current_place == "restrictedone"){
        url = url+"status?status=MSGRS1"
    }
    else if(current_place == "restrictedtwo"){
        url = url+"status?status=MSGRS2"
    }
    else if(current_place == "restrictedthree"){
        url = url+"status?status=MSGRS3"
    }
    $.getJSON(url, function(data){
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
        console.log("The URL of this page is: " + window.location.href);
    });
});

//filtering ends

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


//SUBMIT BUTTON : CHANGE RSPNS MSG
$("#submit").click(function(e) {
    e.preventDefault();

    let checks = validateForm();
    // console.log(checks)
    if ( checks.length > 0){
        if ($("#rspnsmsgtp").val() != "NOTHING"){
            let url = "/api";
            if (current_place === "devices"){
                url = url+"/mltpl/"
            }
            else if(current_place === "activedevices"){
                url = url+"/status/"
            }
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
var mybutton = document.getElementById("goTop");

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


//filter
