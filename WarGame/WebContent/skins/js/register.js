$(document).ready(function() {

    $("#register").click(function(){

        var email = $("#mail").val();

        if(email != 0)
        {
            if(isValidEmailAddress(email))
            {
                $("#mailText").css({
                    "color": "green"
                });
            } else {
                $("#mailText").css({
                	"color": "red"
                });
            }
        } else {
            $("#mailText").css({
                "background-image": "none"
            });         
        }

    });

});

function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    return pattern.test(emailAddress);
}