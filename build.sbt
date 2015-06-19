name := "scodecSample"

version := "1.0"

scalaVersion in ThisBuild := "2.11.1"

resolvers += "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/"

resolvers += "Maven Central Server" at "http://repo1.maven.org/maven2"

resolvers += "MavenRepo" at "http://mvnrepository.com/artifact/"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "org.scodec" %% "scodec-bits" % "1.0.5"

libraryDependencies += "org.scodec" %% "scodec-core" % "1.7.0"

libraryDependencies ++= {
  if (scalaBinaryVersion.value startsWith "2.10")
    Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full))
  else Nil
}

libraryDependencies += "org.scodec" %% "scodec-scalaz" % "1.0.0"
