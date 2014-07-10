import sbt.Keys._
import sbt._

object build extends Build {

  lazy val example = Project(id = "example", base = file("."), settings = exampleSettings)

  def exampleSettings = {
    Defaults.coreDefaultSettings ++
      Seq(
        organization := "test",
        version := "1.0.0",
        scalaVersion := "2.10.4",
        scalacOptions := Seq(
          "-deprecation",
          "-encoding", "UTF-8",
          "-feature",
          "-unchecked"),
        resolvers ++= Seq(
          Classpaths.sbtPluginReleases,
          "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
          "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
          "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
        ),
        libraryDependencies ++= Seq(
          "org.scalanlp" %% "breeze" % "0.8.1",
          "org.scalanlp" %% "breeze-natives" % "0.8.1",

          // Including this dependencies gives an error saying:
          // "unresolved dependency: org.scala-sbt#sbt;0.13.1: not found"
          "org.scalanlp" %% "epic-parser-en-span" % "2014.6.3-SNAPSHOT"
        )
      )
  }
}
