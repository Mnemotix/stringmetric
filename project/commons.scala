import com.typesafe.sbt.pgp.PgpKeys._
import sbt.Keys._
import sbt._

object Settings {

	val commonSettings: Seq[Def.Setting[_]] = Seq(
		organization := "com.mnemotix",
		homepage := Some(url("https://rockymadden.com/stringmetric/")),
		scalaVersion := "2.12.6",
		crossScalaVersions := Seq("2.11.12", "2.12.6"),
		scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint"),
		licenses := Seq("Apache 2.0" -> url("https://opensource.org/licenses/Apache-2.0")),
		developers := List(
			Developer(
				id = "rockymadden",
				name = "Rocky Madden",
				email = "github@rockymadden.com",
				url = url("https://rockymadden.com/")
			),
			Developer(
				id = "ndelaforge",
				name = "Nicolas Delaforge",
				email = "nicolas.delaforge@mnemotix.com",
				url = url("https://www.mnemotix.com/")
			)
		),
		pomExtra :=
			<url>http://rockymadden.com/stringmetric/</url>
				<licenses>
					<license>
						<name>MIT</name>
						<distribution>repo</distribution>
					</license>
				</licenses>
				<scm>
					<url>git@github.com:rockymadden/stringmetric.git</url>
					<connection>scm:git:git@github.com:rockymadden/stringmetric.git</connection>
				</scm>
				<developers>
					<developer>
						<id>rockymadden</id>
						<name>Rocky Madden</name>
						<url>http://rockymadden.com/</url>
					</developer>
				</developers>,
		pomIncludeRepository := { _ => false },
		publishMavenStyle := true,
		publishArtifact := true,
		updateOptions := updateOptions.value.withGigahorse(false),
		updateOptions := updateOptions.value.withCachedResolution(true),
		useGpg := true,
		publishTo := Some(
			if (isSnapshot.value)
				Opts.resolver.sonatypeSnapshots
			else
				Opts.resolver.sonatypeStaging
		)
	)
}
