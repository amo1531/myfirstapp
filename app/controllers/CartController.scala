package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

class CartController @Inject()(cc: ControllerComponents)extends AbstractController (cc) {

  def addToCart()=Action {
    implicit request => {
     Ok("kkkkk......")
    }
  }



}