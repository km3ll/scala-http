import sbt._

object SbtDependencies {

  val basic: Seq[ModuleID] = Seq(
    "org.typelevel"               %% "cats-core"       % "2.0.0",
    "org.typelevel"               %% "cats-effect"     % "2.0.0",
    "org.apache.commons"          %  "commons-lang3"   % "3.3.2",
    "com.typesafe"                %  "config"          % "1.3.2",
    "ch.qos.logback"              %  "logback-classic" % "1.1.3",
    "io.monix"                    %% "monix"           % "2.3.3",
    "org.scalacheck"              %% "scalacheck"      % "1.14.0",
    "org.scalatest"               %% "scalatest"       % "3.0.5",
    "com.typesafe.scala-logging"  %% "scala-logging"   % "3.9.2",
    "com.github.pureconfig"       %% "pureconfig"      % "0.17.1"

  )

  val http: Seq[ModuleID] = Seq(
    "com.typesafe.akka"           %% "akka-actor-typed"   % "2.6.8",
    "com.typesafe.akka"           %% "akka-stream"        % "2.6.8",
    "com.typesafe.akka"           %% "akka-http"          % "10.2.4",
    "de.heikoseeberger"           %% "akka-http-circe"    % "1.20.1",
    "com.typesafe.akka"           %% "akka-http-testkit"  % "10.2.4",
    "io.circe"                    %% "circe-core"         % "0.9.3",
    "io.circe"                    %% "circe-generic"      % "0.9.3",
    "io.circe"                    %% "circe-parser"       % "0.9.3",
    "io.circe"                    %% "circe-java8"        % "0.9.3",
  ) ++ basic

}
