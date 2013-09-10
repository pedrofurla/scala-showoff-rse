import sbt._
import Keys._

object ShowoffBuild extends Build {

  lazy val servlet = project in file("servlet")

  lazy val showoff = project.in( file(".") ).aggregate(servlet).dependsOn(servlet)

}

