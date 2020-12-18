ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "com.alexitc"
ThisBuild / version := "0.1.0"

lazy val root = (project in file("."))
  .configure(_.enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin, ScalablyTypedConverterGenSourcePlugin))
  .settings(
    name := "sjs-material-ui-facade",
    requireJsDomEnv in Test := true,
    stTypescriptVersion := "3.9.3",
    stFlavour := Flavour.Slinky,
    stMinimize := Selection.AllExcept("@material-ui/core", "@material-ui/styles", "@material-ui/icons"),
    stOutputPackage := "com.alexitc.materialui.facade",
    publishMavenStyle := true,
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
    sources in (Compile, doc) := Nil,
    publishArtifact in (Compile, packageDoc) := false
  )

