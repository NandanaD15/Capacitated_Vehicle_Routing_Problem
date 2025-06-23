//import sbt.Keys.libraryDependencies
//
//ThisBuild / version := "0.1.0-SNAPSHOT"
//ThisBuild / scalaVersion := "2.13.16"
//
//lazy val root = (project in file("."))
//  .settings(
//    name := "VRP",
//
//
//    libraryDependencies += "org.junit.jupiter" % "junit-jupiter" % "5.10.0" % Test,
//
//
////    Compile / unmanagedSourceDirectories += baseDirectory.value / "src" / "main" / "java",
////    Test / unmanagedSourceDirectories += baseDirectory.value / "src" / "test" / "java"
//  )
ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .enablePlugins(JupiterPlugin)
  .settings(
    name := "VRP",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter" % "5.10.0" % Test
  )
