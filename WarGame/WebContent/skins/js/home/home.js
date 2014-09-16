$(document).ready(function(){


	$('#homeTitle').on('mouseout',function(){
        $('#homeTitle').css({
        	"font-weight" : "normal",
            "color": "black"
        });
	});

	$('#homeTitle').on('mouseover',function(){
        $('#homeTitle').css({
        	"font-weight" : "bold",
            "color": "red"
        });
	});
	
});

$(window).load(function(){
	var user = new UserModel();
	user.set({idUser: 31});
	user.fetch({
			success : function(userResp)
			{
				loadUserView(userResp);
			}
	});	
});

function loadUserView(userMod)
{
	var userView = new UserView({model: userMod});
	userView.render();
	$("#container").load();
}
