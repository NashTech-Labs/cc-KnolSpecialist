organization in ThisBuild := "com.knoldus"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.8"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % Test

lazy val `cc-knolspecialist` = (project in file("."))
  .aggregate(`cc-knolspecialist-api`, `cc-knolspecialist-impl`, `cc-knolspecialist-stream-api`, `cc-knolspecialist-stream-impl`)

lazy val `cc-knolspecialist-api` = (project in file("cc-knolspecialist-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `cc-knolspecialist-impl` = (project in file("cc-knolspecialist-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`cc-knolspecialist-api`)

lazy val `cc-knolspecialist-stream-api` = (project in file("cc-knolspecialist-stream-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `cc-knolspecialist-stream-impl` = (project in file("cc-knolspecialist-stream-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .dependsOn(`cc-knolspecialist-stream-api`, `cc-knolspecialist-api`)
