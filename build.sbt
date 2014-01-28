name := "ScalatronBots"

artifactName := { (_, _, _) => "ScalatronBot.jar" }

scalaVersion := "2.9.3"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
    