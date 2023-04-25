name := "UT-IT"

version := "0.1"

scalaVersion := "2.13.4"

val scalaTest = "org.scalatest" %% "scalatest" % "3.2.15" % Test
val logger = "org.slf4j" % "slf4j-simple" % "2.0.5"

lazy val module1 = project
  .settings(
    libraryDependencies += scalaTest,
    libraryDependencies += logger
  )

lazy val module2 = project
  .settings(
    libraryDependencies += scalaTest,
    libraryDependencies += logger
  )