var UserView = Backbone.View.extend({
    tagName: 'div',
    className: '',
    template: _.template( $( '#homeTemplate' ).html() ),

    render: function() {
        //this.el is what we defined in tagName. use $el to get access to jQuery html() function
        this.$el.html( this.template( this.model.attributes ) );

        return this;
    }
});