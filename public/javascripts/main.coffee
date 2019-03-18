window.ShoppingCart = class ShoppingCart

    constructor: ->
        @incrementCount = ".Item_incrCount"
        @decrementCount = ".Item_decCount"
        @addToCartButton = ".Item_addToCart"

    init: ->
        @registerIncrementQuantity()
        @registerDecrementQuantity()
        @registerAddToCart()

    registerAddToCart:() ->
        $(@addToCartButton).on "click",(e) =>
             $this = $(e.target)
             counterElements = $this.parent(".Item_operations").find("ul")
             $(counterElements).removeClass("Hide")
             $this.addClass("Hide")

    registerIncrementQuantity:() ->
        $(@incrementCount).on "click",(e) =>
            $this = $(e.target)
            initialQty = $this.parent(".Item_counter").find(".Item_qty")
            finalQty = parseInt($(initialQty).html()) + 1
            $(initialQty).html(finalQty)

    registerDecrementQuantity:() ->
        $(@decrementCount).on "click",(e) =>
            $this = $(e.target)
            initialQty = $this.parent(".Item_counter").find(".Item_qty")
            if ($(initialQty).html() == "1")
                $this.parents(".Item_operations").find(".Item_addToCart").removeClass("Hide").addClass("Show")
                $this.parent(".Item_counter").addClass("Hide")
            else
                finalQty = parseInt($(initialQty).html()) - 1
                $(initialQty).html(finalQty)


$(document).ready ->
	shoppingCart = new ShoppingCart()
	shoppingCart.init()