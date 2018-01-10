organization  := "org.toktok"
name          := "jtox"
version       := "0.1.0"
scalaVersion  := "2.11.12"

// Tox4j library.
resolvers += Resolver.bintrayRepo("toktok", "maven")

// Build dependencies.
libraryDependencies ++= Seq(
  organization.value %% "tox4j-c" % "0.1.3"
)

import im.tox.sbt.lint.Scalastyle
Scalastyle.projectSettings
