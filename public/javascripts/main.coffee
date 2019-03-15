window.ShoppingCart = class ShoppingCart

    constructor: ->
        @incrementCount = ".Item_incrCount"
        @decrementCount = ".Item_decCount"

    init: ->
       $(@incrementCount).on "click",(e) =>
            $this = $(e.target)
            @incrQuantity($this)

        $(@decrementCount).on "click",(e) =>
            $this = $(e.target)
            @subtractQuantity($this)

    incrQuantity:($this) ->
        initialQty = $this.parent(".Item_counter").find(".Item_qty")
        finalQty = parseInt($(initialQty).html()) + 1
        console.log(finalQty)
        $(initialQty).html(finalQty)

    subtractQuantity:($this) ->
        initialQty = $this.parent(".Item_counter").find(".Item_qty")
        unless ($(initialQty).html() == "1")
            finalQty = parseInt($(initialQty).html()) - 1
            $(initialQty).html(finalQty)

$(document).ready ->
	shoppingCart = new ShoppingCart()
	shoppingCart.init()