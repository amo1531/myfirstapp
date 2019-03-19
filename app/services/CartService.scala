package services

import db.MongoFactory
import javax.inject.Inject
import models.CartItem
import org.mongodb.scala.bson.collection.immutable.Document
import play.api.mvc.Request
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class CartService @Inject()(mongoFactory:MongoFactory) {

  def saveItem(name: String, quantity: Int, price: Double, src: String) =    {

    val collection = mongoFactory.COLLECTION
    val cartDoc: Document = CartItem(name, quantity, price, src).toDocument()
    println("document ----> "+cartDoc)
    val resposnse =  collection.insertOne(cartDoc)
    mongoFactory.GenericObservable(resposnse).result()
  }
}
