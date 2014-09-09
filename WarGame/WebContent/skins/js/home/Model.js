	var UserModel = Backbone.Model.extend({
	   initialize: function() {
	      
	   },
	   idAttribute: "idUser", //PK mapping
	   defaults : {
		   idUser : null,
		   userName : "",
		   mail : ""
	   },
	   urlRoot: baseUrlPath+ '/users' //REST URI mapping
	});

	
	function printData(userName, mail){
	    $('#container').html('User name is... ' + userName +  ' mail...' + mail);
	}
	
	
	
