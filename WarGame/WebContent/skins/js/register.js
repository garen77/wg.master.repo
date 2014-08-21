	$(function(){

	$("#pageForm\\:register").on("click",function(){

        var email = $("#pageForm\\:mailText").val();
        var userName = $("#pageForm\\:userNameText").val();
        var password = $("#pageForm\\:passwordText").val();
        
        if(!userName)
    	{
            $("#pageForm\\:userNameLabel").css({
            	"font-weight" : "bold",
                "color": "black"
            });
    	}

        if(!password)
    	{
            $("#pageForm\\:passwordLabel").css({
            	"font-weight" : "bold",
                "color": "black"
            });
    	}

        if(email != 0)
        {
            if(isValidEmailAddress(email))
            {
                $("#pageForm\\:mailLabel").css({
                    "color": "green"
                });
            } else {
            	
                $("#pageForm\\:mailLabel").css({
                	"color": "red"
                });
            }
        } else {
            $("#pageForm\\:mailLabel").css({
            	"font-weight" : "bold",
                "color": "black"
            });         
        }

    });

  });
	
function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    return pattern.test(emailAddress);
}