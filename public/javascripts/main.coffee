window.ShoppingCart = class ShoppingCart

    constructor: ->

    init: ->
        $(document).on "click",() =>
            console.log("---------->")

$(document).ready ->
	shoppingCart = new ShoppingCart()
	shoppingCart.init()