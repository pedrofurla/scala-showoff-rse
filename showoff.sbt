
name := "scala-showoff"

organization := "com.pf"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.2"

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

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.1" % "test",
  "org.scala-lang" % "scala-reflect" % "2.10.2"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature"
)
