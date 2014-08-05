resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
)

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.0")

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-uglify" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

addSbtPlugin("net.ground5hark.sbt" % "sbt-concat" % "0.1.5")

addSbtPlugin("net.ground5hark.sbt" % "sbt-css-compress" % "0.1.0")

addSbtPlugin("com.slidingautonomy.sbt" % "sbt-filter" % "1.0.0")

//вроде не работает
addSbtPlugin("com.slidingautonomy.sbt" % "sbt-html-minifier" % "1.0.0")

addSbtPlugin("com.slidingautonomy.sbt" % "sbt-imagemin" % "1.0.0")

addSbtPlugin("com.jmparsons.sbt" % "sbt-dustjs-linkedin" % "1.0.2")
