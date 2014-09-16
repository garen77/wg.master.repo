var UserView = Backbone.View.extend({
	el : $('#container'),
	initialize: function() {
		_.bindAll(this, 'render'); 
		this.render();
	},

	render: function(){
		var html = _.template($('#userTemplate').html(), this.model.toJSON());
        this.$el.html(html);
	}
});



