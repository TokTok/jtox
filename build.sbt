organization  := "org.toktok"
name          := "jtox"
version       := "0.1.0"
scalaVersion  := "2.11.12"

// Tox4j library.
resolvers += Resolver.bintrayRepo("toktok", "maven")

// Build dependencies.
libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-log4j12" % "1.7.22",

  organization.value %% "tox4j-c" % "0.1.3"
)

import im.tox.sbt.lint.Scalastyle
Scalastyle.projectSettings

javacOptions := Seq("-Xlint:unchecked")
