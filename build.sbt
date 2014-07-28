name := """my-playful-prelaunch"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).enablePlugins(SbtWeb)

scalaVersion := "2.11.0"

val playVersion = "2.3.0"

libraryDependencies ++= Seq(
  ws,
  cache,
  "com.typesafe.play" %% "play-slick" % "0.8.0-RC2",
  "com.typesafe.play" %% "play" % playVersion,
  "org.webjars" %% "webjars-play" % playVersion,
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc41",
  "org.seleniumhq.selenium" % "selenium-java" % "2.42.2",
  "com.typesafe.play.plugins" %% "play-plugins-mailer" % "2.3.0"
  //  "org.webjars" % "bootstrap" % "3.1.1-2"
)

scalacOptions ++= Seq(
  "-feature",
  "-language:postfixOps"  //This allows the postfix operator * to be enabled
)

includeFilter in (Assets, LessKeys.less) := "*.less"

CoffeeScriptKeys.sourceMap := false

pipelineStages := Seq(htmlMinifier,filter,uglify,cssCompress,concat,gzip)

UglifyKeys.sourceMap := false

LessKeys.sourceMap := false

//UglifyKeys.uglifyOps := { js =>
//  Seq((js.sortBy(_._2), "concat.min.js"))
//}

CssCompress.suffix := ".min.css"

Concat.groups := Seq(
  "style-group.css" -> Seq("stylesheets/bootstrap.min.css", "stylesheets/foo.min.css", "stylesheets/index.min.css"),
  "script-group.js" -> Seq("javascripts/jquery.min.js", "javascripts/bootstrap.min.js", "javascripts/foo.min.js", "javascripts/test.min.js")
)