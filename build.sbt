organization in ThisBuild := "com.knoldus.cc"
version in ThisBuild := "1.0-SNAPSHOT"
lagomCassandraEnabled in ThisBuild := false
lagomCassandraPort in ThisBuild := 9042

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.8"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"

val knolspecialist = (project in file("."))
  .aggregate(ccingestionapi, ccingestionimpl, ksapi, ksimpl, analyticsapi, analyticsimpl)

lazy val ccingestionapi = (project in file("cc-ingestion-api"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      lagomScaladslTestKit,
      scalaTest % Test
    )
  )

lazy val ksapi = (project in file("ks-api"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      lagomScaladslTestKit,
      scalaTest % Test
    )
  ).dependsOn(domains)

lazy val analyticsapi = (project in file("analytics-api"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      lagomScaladslTestKit,
      scalaTest % Test
    )
  )

lazy val ccingestionimpl = (project in file("cc-ingestion-impl"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest % Test
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(ccingestionapi)

lazy val ksimpl = (project in file("ks-impl"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest % Test,
      "org.postgresql" % "postgresql" % "9.4.1208.jre7",
      "com.github.dnvriend" %% "akka-persistence-jdbc" % "2.5.2.0"
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(ksapi, domains)

lazy val analyticsimpl = (project in file("analytics-impl"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest % Test
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(analyticsapi)

lazy val domains = (project in file("domains"))
  .enablePlugins(LagomScala)
  .settings(lagomForkedTestSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      scalaTest % Test
    )
  ).settings(lagomForkedTestSettings: _*)

