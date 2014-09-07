var UserView = Backbone.View.extend({
	el : $('#pageForm\\:homeView'),
	initialize: function() {
		_.bindAll(this, 'render'); 
		this.render();
	},

	render: function(){
		$(this.el).append("<ul> <li>hello world</li> </ul>");
	}
});



