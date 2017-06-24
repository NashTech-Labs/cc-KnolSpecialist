// The Lagom plugin
addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.3.4")
// Needed for importing the project into Eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.1.0")

resolvers += Resolver.sonatypeRepo("releases")
addSbtPlugin("org.brianmckenna" % "sbt-wartremover" % "0.11")
