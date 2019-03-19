package controllers

import javax.inject.Inject
import org.mongodb.scala.Completed
import play.api.mvc._
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents}
import services.CartService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class CartController @Inject()(cc: ControllerComponents, cartService:CartService) extends AbstractController (cc) {

  def addToCart(): Action[AnyContent] = Action {
    implicit request => {

      val name: String = request.getQueryString("itemName").getOrElse("")
      val quantity: Int = request.getQueryString("itemQty").getOrElse("0").toInt
      val price = request.getQueryString("itemPrice").getOrElse("0").toDouble
      val src: String = request.getQueryString("imgSource").getOrElse("")

      val response: Future[Seq[Completed]] = cartService.saveItem(name, quantity, price, src)
//      response.map {
//        case Right(resp) => OK("Successfully inserted to the cart...!!!")
//        case Left(error) => OK("Failed to add to the cart...!!!")
//      }
      println("===========>"+response)
      Ok("")
    }
  }
}