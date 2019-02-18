package models

import javax.inject.Inject

case class Item @Inject()(name:String,price:Integer,imageSrc:String)
