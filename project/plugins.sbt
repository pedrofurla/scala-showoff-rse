resolvers ++= Seq(
"Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  Resolver.url(
    "Typesafe Ivy Snapshots",
    url("http://repo.typesafe.com/typesafe/ivy-snapshots/"))(Resolver.ivyStylePatterns),
  Resolver.url(
    "Typesafe Snapshots with ivy style",
    url("http://repo.typesafe.com/typesafe/snapshots/"))(Resolver.ivyStylePatterns)
)

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.5.0-SNAPSHOT")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.3.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.1")