package db

import java.sql.DriverManager

import com.google.inject.Inject

class MySQLDatabaseManager @Inject() () {

  private def getConnection={
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://localhost:9001/mycart","root","12345678")
  }

  def getResultSet(sql:String)={
    val connection = getConnection
    val statement = connection.createStatement()
    statement.executeQuery(sql)
  }

  def executeSql(sql:String):Int={
    val connection = getConnection
    val statement = connection.createStatement()
    statement.executeUpdate(sql)
  }

}
