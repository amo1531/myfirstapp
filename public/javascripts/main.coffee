window.ShoppingCart = class ShoppingCart

    constructor: ->
        @incrementCount = ".Item_incrCount"
        @decrementCount = ".Item_decCount"
        @addToCartButton = ".Item_addToCart"
        @removeFromCartButton = ".Item_removeFromCart"

    init: ->
        @registerIncrementQuantity()
        @registerDecrementQuantity()
        @registerAddToCart()
        @registerRemoveFromCart()

    registerAddToCart:() ->
        $(@addToCartButton).on "click",(e) =>
            $this = $(e.target)
            counterElements = $this.parent(".Item_operations").find("ul")
            $this.addClass("Hide")
            $this.parent(".Item_operations").find(@removeFromCartButton).removeClass("Hide")

            itemName = $this.parents(".Item_info").find(".Item_name").html()
            itemPrice = $this.parents(".Item_info").find(".Item_price").html()
            itemQty = $this.parents(".Item_info").find(".Item_qty").html()
            imgSource = $this.parents(".Item_info").find("img").attr("src")

            console.log(itemName+" "+itemPrice+" "+itemQty+" "+imgSource)

            $.ajax({
                url: "/addtocart?itemName="+itemName+"&itemPrice="+itemPrice+"&itemQty="+itemQty+"&imgSource="+imgSource
                success: (result) =>
            })


    registerRemoveFromCart:() ->
        $(@removeFromCartButton).on "click",(e) =>
            $this = $(e.target)
            $this.addClass("Hide")
            $this.parent(".Item_operations").find(@addToCartButton).removeClass("Hide")
            $this.parents(".Item_info").find(".Item_qty").html("1")
            itemName = $this.parents(".Item_info").find(".Item_name").html()
            console.log(itemName)
            $.ajax({
                url: "/removefromcart?itemName="+itemName
                success: (result) =>
            })

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
            unless ($(initialQty).html() == "1")
                finalQty = parseInt($(initialQty).html()) - 1
                $(initialQty).html(finalQty)

#$this.parents(".Item_operations").find(".Item_addToCart").removeClass("Hide").addClass("Show")
#$this.parent(".Item_counter").addClass("Hide")


$(document).ready ->
	shoppingCart = new ShoppingCart()
	shoppingCart.init()