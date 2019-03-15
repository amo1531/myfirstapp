name := """myfirstapp"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  jdbc,
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.6.0"

)
