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