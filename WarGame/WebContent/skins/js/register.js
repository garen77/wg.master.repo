	$(document).ready(function(){

        var canSubmitMail = false;
        var canSubmitUsername = false;
        var canSubmitPassword = false;
        
        var emailLabel = $("#pageForm\\:mailLabel");
        var userNameLabel = $("#pageForm\\:userNameLabel");
        var passwordLabel = $("#pageForm\\:passwordLabel");

		$("#pageForm\\:mailText").on("blur",function(){
			if($(this).val() == null || $(this).val()==''
				|| !isValidEmailAddress($(this).val()))
			{
				canSubmitMail = false;
	            $(emailLabel).css({
	            	"font-weight" : "bold",
	                "color": "black"
	            });
			}
			else
			{
				canSubmitMail = true;
				$("#pageForm\\:registerButton").attr('disabled', false);
	            $(emailLabel).css({
	            	"font-weight" : "normal",
	                "color": "black"
	            });
			}	
		});
		
		$("#pageForm\\:userNameText").on("blur",function(){
			if($(this).val() == null || $(this).val()=='')
			{
				canSubmitUsername = false;
	            $(userNameLabel).css({
	            	"font-weight" : "bold",
	                "color": "black"
	            });
			}	
			else
			{
				canSubmitUsername = true;
				$("#pageForm\\:registerButton").attr('disabled', false);
	            $(userNameLabel).css({
	            	"font-weight" : "normal",
	                "color": "black"
	            });
			}	
		});
		
		$("#pageForm\\:passwordText").on("blur",function(){
			if($(this).val() == null || $(this).val()=='')
			{
				canSubmitPassword = false;
	            $(passwordLabel).css({
	            	"font-weight" : "bold",
	                "color": "black"
	            });
			}	
			else
			{
				canSubmitPassword = true;
				$("#pageForm\\:registerButton").attr('disabled', false);
	            $(passwordLabel).css({
	            	"font-weight" : "normal",
	                "color": "black"
	            });
			}	
		});

		$("#pageForm\\:registerButton").on("mouseover",function(){
			if(canSubmitMail && canSubmitUsername && canSubmitPassword)
			{
				$("#pageForm\\:registerButton").attr('disabled', false);
			}
			else
			{
				$("#pageForm\\:registerButton").attr('disabled', true);
			}	
		});

  });
	
function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    return pattern.test(emailAddress);
}