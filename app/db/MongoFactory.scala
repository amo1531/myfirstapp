package db

import org.mongodb.scala._

object MongoFactory {

  private val SERVER = "localhost"
  private val PORT = 27017
  private val DATABASE = "orders"
  private val COLLECTION = "items"

  val mongoClient: MongoClient = MongoClient(s"mongodb://${SERVER}")
  val database: MongoDatabase = mongoClient.getDatabase(s"${DATABASE}")

}