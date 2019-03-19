package models

import javax.inject.Inject
import org.mongodb.scala.bson.collection.immutable.Document

case class CartItem @Inject()(name:String,quantity:Int, price:Double,imageSrc:String) {

  def toDocument(): Document = {
    val data = s"""{"name": "$name", "price": "$price", "quantity": "$quantity","imageSrc": "$imageSrc"}"""
    Document(data)
  }

}

