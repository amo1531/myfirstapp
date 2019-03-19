package db

import javax.inject.Inject
import models.CartItem
import org.mongodb.scala._
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}

import scala.concurrent.Future

class MongoFactory @Inject()() {

  trait ImplicitObservable[C] {
    val observable: Observable[C]
    val converter: (C) => String
    def result(): Future[Seq[C]] = observable.toFuture()
  }

  implicit class GenericObservable[C](val observable: Observable[C]) extends ImplicitObservable[C] {
    override val converter: (C) => String = (doc) => doc.toString
  }

  val DOCUMENT_ID = "_id"
  private val USERNAME = ""
  private val PASSWORD = ""
  private val SERVER = "localhost"
  private val PORT = 27017
  private val DATABASE_NAME = "orders"
  private val COLLECTION_NAME = "items"

  private val CONNECTION_URL = s"$USERNAME" match {
    case "" => s"mongodb://${SERVER}:${PORT}/${DATABASE_NAME}"
    case _ => s"mongodb://$USERNAME:$PASSWORD@${SERVER}:${PORT}/${DATABASE_NAME}"
  }

  val MONGO_CLIENT = MongoClient(CONNECTION_URL)
  val DATABASE = MONGO_CLIENT.getDatabase(s"${DATABASE_NAME}")
  val COLLECTION = DATABASE.getCollection(s"${COLLECTION_NAME}")


}