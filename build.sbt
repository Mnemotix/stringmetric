
lazy val root = Project("stringmetric", file("."))
	.settings(Settings.commonSettings)
	.settings(
		publishArtifact := false,
		version in ThisBuild := "0.28.0-SNAPSHOT"
	)
	.aggregate(core, cli)

lazy val core = Project("stringmetric-core", file("core"))
	.settings(Settings.commonSettings)
	.settings(
		libraryDependencies ++= Seq(
			"org.specs2" %% "specs2-core" % "4.0.4" % "test",
			"org.specs2" %% "specs2-junit" % "4.0.4" % Test
		)
	)

lazy val cli = Project("stringmetric-cli", file("cli"))
	.settings(Settings.commonSettings)
	.settings(
		libraryDependencies ++= Seq(
			"org.specs2" %% "specs2-core" % "4.0.4" % "test",
			"org.specs2" %% "specs2-junit" % "4.0.4" % Test
		)
	)
	.dependsOn(core)
