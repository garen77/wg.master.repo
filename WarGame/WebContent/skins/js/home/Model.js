var UserModel = Backbone.Model.extend({
	
	idAttribute : "idUser",
	urlRoot: baseUrlPath+'/users',
	
	defaults :{
		
		"idUser" : "", 
		
		"userName" : "",
		
		"mail" : ""
	},
	
	url: function() {
		return this.urlRoot + '/' + this.idUser;
	}

});

//var user = new UserModel({idUser:22}).fetch();