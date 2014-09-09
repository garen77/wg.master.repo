$(document).ready(function(){


	$('#homeTitle').on('mouseout',function(){
        $('#homeTitle').css({
        	"font-weight" : "bold",
            "color": "black"
        });
	});

	$('#homeTitle').on('mouseover',function(){
        $('#homeTitle').css({
        	"font-weight" : "normal",
            "color": "red"
        });
	});
	

	
});

var user = new UserModel();
user.set({idUser: 21});
user.fetch({
		success : function(userResp)
		{
			printData(userResp.get("userName"), userResp.get("mail"));
		}
});
