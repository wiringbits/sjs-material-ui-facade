ThisBuild / organization := "com.alexitc"

inThisBuild(List(
  organization := "com.alexitc",
  homepage := Some(url("https://github.com/wiringbits/sjs-material-ui-facade")),
  licenses := List("MIT" -> url("http://www.opensource.org/licenses/mit-license.html")),
  developers := List(
    Developer(
      "AlexITC",
      "Alexis Hernandez",
      "alexis22229@gmail.com",
      url("https://wiringbits.net")
    )
  )
))

lazy val root = (project in file("."))
  .configure(_.enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin, ScalablyTypedConverterGenSourcePlugin))
  .settings(
    scalaVersion := "3.1.1",
    crossScalaVersions ++= Seq("2.13.12", "3.1.1"),
    name := "sjs-material-ui-facade",
    Test / requireJsDomEnv := true,
    stTypescriptVersion := "3.9.3",
    stFlavour := Flavour.Slinky,
    stMinimize := Selection.AllExcept("@material-ui/core", "@material-ui/styles", "@material-ui/icons"),
    stOutputPackage := "com.alexitc.materialui.facade",
    stReactEnableTreeShaking := Selection.All,
    stUseScalaJsDom := true,
    // disabled because it somehow triggers many warnings
    scalaJSLinkerConfig ~= (_.withSourceMap(false)),
    useYarn := true,
    Compile / npmDependencies ++= Seq(
      "@material-ui/core" -> "3.9.4", // note: version 4 is not supported yet
      "@material-ui/styles" -> "3.0.0-alpha.10", // note: version 4 is not supported yet
      "@material-ui/icons" -> "3.0.2",
    ),
    // docs are huge and unnecessary
    Compile / doc / sources := Nil,
  )
