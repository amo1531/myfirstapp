package controllers

import akka.stream.javadsl.JavaFlowSupport.Source
import javax.inject._
import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import scala.io.Source
import play.api.Environment

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */

class HomeController @Inject() (cc: ControllerComponents) extends AbstractController (cc) {
    /**
      * Create an Action to render an HTML page.
      * The configuration in the `routes` file means that this method
      * will be called when the application receives a `GET` request with
      * a path of `/`.
    **/

  def index() = Action {
    implicit request => {

      val json: JsValue = Json.parse("{\n  \"fruits\" : [\n    {\"itemName\":\"apples\",\"itemPrice\":\"60\",\"imageSrc\":\"/assets/images/fruits/\"},\n    {\"itemName\":\"bananas\",\"itemPrice\":\"60\",\"imageSrc\":\"/assets/images/fruits/\"},\n    {\"itemName\":\"oranges\",\"itemPrice\":\"150\",\"imageSrc\":\"/assets/images/fruits/\"},\n    {\"itemName\":\"mangoes\",\"itemPrice\":\"120\",\"imageSrc\":\"/assets/images/fruits/\"}\n  ],\n\n  \"vegetables\" : [\n    {\"itemName\":\"onion\",\"itemPrice\":\"25\",\"imageSrc\":\"/assets/images/vegetables/\"},\n    {\"itemName\":\"potato\",\"itemPrice\":\"20\",\"imageSrc\":\"/assets/images/vegetables/\"},\n    {\"itemName\":\"capsicum\",\"itemPrice\":\"30\",\"imageSrc\":\"/assets/images/vegetables/\"},\n    {\"itemName\":\"brinjal\",\"itemPrice\":\"25\",\"imageSrc\":\"/assets/images/vegetables/\"}\n  ],\n\n  \"dairy\" : [\n    {\"itemName\":\"bread\",\"itemPrice\":\"35\",\"imageSrc\":\"/assets/images/dairy/\"},\n    {\"itemName\":\"butter\",\"itemPrice\":\"50\",\"imageSrc\":\"/assets/images/dairy/\"},\n    {\"itemName\":\"eggs\",\"itemPrice\":\"90\",\"imageSrc\":\"/assets/images/dairy/\"},\n    {\"itemName\":\"milkmaid\",\"itemPrice\":\"150\",\"imageSrc\":\"/assets/images/dairy/\"}\n  ],\n\n  \"grossary\": [\n    {\"itemName\":\"cooking Oil\",\"itemPrice\":\"450\",\"imageSrc\":\"/assets/images/grossary/\"},\n    {\"itemName\":\"wheat Flour\",\"itemPrice\":\"200\",\"imageSrc\":\"/assets/images/grossary/\"},\n    {\"itemName\":\"basmati rice\",\"itemPrice\":\"120\",\"imageSrc\":\"/assets/images/grossary/\"},\n    {\"itemName\":\"sugar\",\"itemPrice\":\"80\",\"imageSrc\":\"/assets/images/grossary/\"}\n  ]\n}")
      Ok(views.html.index(json.toString()))
    }
  }

}

