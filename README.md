# scalajs material-ui facade

This is a facade generated [scalablytyped](https://scalablytyped.org/), wrapping [material-ui v3](https://v3.material-ui.com/).

The pre-packaged library prevents the huge build times required to generating such facade.


## Usage

1. Make sure to use the same scalajs version where the facade is compiled (check the [plugins.sbt](project/plugins.sbt) for the exact version).
1. Include the dependency on your `build.sbt` by adding `libraryDependencies += "com.alexitc" %%% "sjs-material-ui-facade" % "0.1.2"`
1. Exclude material-ui from scalablytyped to avoid the huge build times: `stIgnore ++= List("@material-ui/core", "@material-ui/styles", "@material-ui/icons")`
1. Check the usage on this [project](https://github.com/wiringbits/cazadescuentos/tree/master/pwa) for specific details.
