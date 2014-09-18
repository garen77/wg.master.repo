var UserView = Backbone.View.extend({
	el : $('#container'),
	initialize: function() {
		_.bindAll(this, 'render'); 
		this.render();
	},

	render: function(){
		var features = this.model.idFeatures;
		var userFeaturesTemplate = _.template($('#userFeaturesTemplate').html());
		var htmlUserFeaturesTemplate = userFeaturesTemplate({'featuresList' : features});
		$("#tableUserFeatures").html(htmlUserFeaturesTemplate);
		
		var html = _.template($('#userTemplate').html(), this.model.toJSON());
        this.$el.html(html);
	}
});



