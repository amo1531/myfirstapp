package controllers

import javax.inject._
import models.Item
import play.api.mvc._
import services.HomeService

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */

class HomeController @Inject() (cc: ControllerComponents,homeService:HomeService) extends AbstractController (cc) {
    /**
      * Create an Action to render an HTML page.
      * The configuration in the `routes` file means that this method
      * will be called when the application receives a `GET` request with
      * a path of `/`.
    **/

  def index(): Action[AnyContent] = Action {
    implicit request => {
      Ok(views.html.index())
    }
  }

  def getFruits() = Action {
    implicit request => {
      val listOfFruits = homeService.getFruitsList()
      Ok(views.html.fruitsSection(listOfFruits))
    }
  }

  def getVegetables() = Action {
    implicit request => {
      val listOfVegetables = homeService.getVegetablesList()
      Ok(views.html.vegetablesSection(listOfVegetables))
    }
  }

  def getDairy() = Action {
    implicit request => {
      val listOfDairy = homeService.getDairyList()
      Ok(views.html.dairySection(listOfDairy))
    }
  }

  def getGrossary() = Action {
    implicit request => {
      val listOfGrossary = homeService.getGrossaryist()
      Ok(views.html.grossarySection(listOfGrossary))
    }
  }

}

