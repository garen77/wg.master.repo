var  User = Backbone.Model.extend({
	urlRoot: baseUrlPath,
	url: function() {
		return this.urlRoot + '/' + this.idUser;
	}
});

var user = new User({idUser:20}).fetch();