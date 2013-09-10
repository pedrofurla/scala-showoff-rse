import com.earldouglas.xsbtwebplugin.PluginKeys._

name := "fixing-servlet"

organization := "com.pf"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.2"

seq(webSettings :_*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"
