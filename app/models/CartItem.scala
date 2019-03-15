package models

import javax.inject.Inject

case class CartItem @Inject()(name:String,price:Integer,imageSrc:String,quantity:Int)

