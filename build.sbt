organization := "middle-earth"
name := "scala-http"
version := "0.1"
scalaVersion := "2.12.8"

libraryDependencies ++= SbtDependencies.http
scalacOptions ++= SbtOptions.compiler

addCommandAlias( "check", "clean; update; compile; test:compile; test")