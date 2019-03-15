package services

import javax.inject.Inject
import models.Item

class ItemService @Inject() () {

  def getVegetablesList() = {
    List(Item("onion",25,"/assets/images/vegetables/onions.jpg"),Item("potato",20,"/assets/images/vegetables/potato.png"),
      Item("capsicum",30,"/assets/images/vegetables/capsicum.jpg"),Item("brinjal",25,"/assets/images/vegetables/brinjal.jpg"))
  }

  def getFruitsList() = {
    List(Item("apples",120,"/assets/images/fruits/apple.jpg"),Item("bananas",60,"/assets/images/fruits/banana.jpg"),
      Item("oranges", 150,"/assets/images/fruits/orange.jpg"),Item("mangoes",120,"/assets/images/fruits/mango.jpg"))
  }

  def getDairyList()  = {
    List(Item("bread",35,"/assets/images/dairy/bread.png"),Item("butter",80,"/assets/images/dairy/butter.jpg"),
      Item("eggs",90,"/assets/images/dairy/eggs.jpeg"),Item("milkmaid",150,"/assets/images/dairy/milkmaid.jpg"))
  }

  def getGrossaryist() ={
    List(Item("cooking Oil",450,"/assets/images/grossary/oil.jpg"),Item("wheat Flour",200,"/assets/images/grossary/aata.png"),
      Item("basmati rice",120,"/assets/images/grossary/rice.jpg"),Item("sugar",50,"/assets/images/grossary/sugar.jpg"))
  }
}
