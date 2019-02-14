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
      Ok(views.html.index())
    }
  }

  def getFruits() = Action {
    implicit request => {
      val fruitsData ="{\n  \"fruits\" : [\n    {\"itemName\":\"apples\",\"itemPrice\":\"60\",\"imageSrc\":\"/assets/images/fruits/apple.jpg\"},\n    {\"itemName\":\"bananas\",\"itemPrice\":\"60\",\"imageSrc\":\"/assets/images/fruits/banana.jpg\"},\n    {\"itemName\":\"oranges\",\"itemPrice\":\"150\",\"imageSrc\":\"/assets/images/fruits/orange.jpg\"},\n    {\"itemName\":\"mangoes\",\"itemPrice\":\"120\",\"imageSrc\":\"/assets/images/fruits/mango.jpg\"}\n  ]\n}"
      Ok(views.html.fruitsSection(fruitsData))
    }
  }

  def getVegetables() = Action {
    implicit request => {
      val vegData = "{  \"vegetables\" : [\n    {\"itemName\":\"onion\",\"itemPrice\":\"25\",\"imageSrc\":\"/assets/images/vegetables/onions.jpg\"},\n    {\"itemName\":\"potato\",\"itemPrice\":\"20\",\"imageSrc\":\"/assets/images/vegetables/potato.jpg\"},\n    {\"itemName\":\"capsicum\",\"itemPrice\":\"30\",\"imageSrc\":\"/assets/images/vegetables/capsicum.jpg\"},\n    {\"itemName\":\"brinjal\",\"itemPrice\":\"25\",\"imageSrc\":\"/assets/images/vegetables/brinjal.jpg\"}\n  ]\n}"
      Ok(views.html.vegetablesSection(vegData))
    }
  }

  def getDairy() = Action {
    implicit request => {
      val dairyData = "{  \"dairy\" : [\n    {\"itemName\":\"bread\",\"itemPrice\":\"35\",\"imageSrc\":\"/assets/images/dairy/bread.jpg\"},\n    {\"itemName\":\"butter\",\"itemPrice\":\"80\",\"imageSrc\":\"/assets/images/dairy/butter.jpg\"},\n    {\"itemName\":\"eggs\",\"itemPrice\":\"90\",\"imageSrc\":\"/assets/images/dairy/eggs.jpeg\"},\n    {\"itemName\":\"milkmaid\",\"itemPrice\":\"150\",\"imageSrc\":\"/assets/images/dairy/milkmaid.jpg\"}\n  ]\n}"
      Ok(views.html.dairySection(dairyData))
    }
  }

  def getGrossary() = Action {
    implicit request => {
      val grossaryData = "{\"grossary\": [\n    {\"itemName\":\"cooking Oil\",\"itemPrice\":\"450\",\"imageSrc\":\"/assets/images/grossary/oil.jpg\"},\n    {\"itemName\":\"wheat Flour\",\"itemPrice\":\"200\",\"imageSrc\":\"/assets/images/grossary/aata.png\"},\n    {\"itemName\":\"basmati rice\",\"itemPrice\":\"120\",\"imageSrc\":\"/assets/images/grossary/rice.jpg\"},\n    {\"itemName\":\"sugar\",\"itemPrice\":\"80\",\"imageSrc\":\"/assets/images/grossary/sugar.jpg\"}\n  ]\n}"
      Ok(views.html.grossarySection(grossaryData))
    }
  }

}

