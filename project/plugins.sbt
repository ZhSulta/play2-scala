resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.0")

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.1")

//addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-uglify" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

addSbtPlugin("net.ground5hark.sbt" % "sbt-concat" % "0.1.5")

addSbtPlugin("net.ground5hark.sbt" % "sbt-css-compress" % "0.1.0")

addSbtPlugin("com.slidingautonomy.sbt" % "sbt-filter" % "1.0.0")

//вроде не работает
addSbtPlugin("com.slidingautonomy.sbt" % "sbt-html-minifier" % "1.0.0")

addSbtPlugin("com.slidingautonomy.sbt" % "sbt-imagemin" % "1.0.0")
