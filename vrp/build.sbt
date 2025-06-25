ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
      name := "VRP",

      // Enable preview features for Java compilation
      javacOptions ++= Seq("--enable-preview", "--release", "21"),

      // Enable preview features for Scala (release target)
      scalacOptions ++= Seq("--release", "21"),

      // Enable preview features at runtime
      fork := true,
      javaOptions += "--enable-preview",

      // Enable preview features during tests
      Test / fork := true,
      Test / javaOptions += "--enable-preview"
  )
