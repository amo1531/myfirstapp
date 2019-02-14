package models

import javax.inject.Inject
import play.api.libs.json.JsValue

case class Items @Inject()(itemName:String,itemPrice:Integer,imageSrc:String) {

}
