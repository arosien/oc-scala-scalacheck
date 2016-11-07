scalaVersion := "2.11.8"

// No "test" scoping in order to write tests in the tutorial.
libraryDependencies ++=
  Seq(
    "org.scalacheck" %% "scalacheck"           % "1.13.0",
    "org.scalatest"  %% "scalatest"            % "3.0.0",
    "org.scalaz"     %% "scalaz-core"          % "7.1.11",
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.13" % "1.1.3")

initialCommands in console :=
  """|import net.rosien.ocscala._
     |import org.scalacheck._
     |
     |val repl = REPLesent(0, 0, "src/main/repl/scalacheck.txt")
     |import repl._
     |h
  """.stripMargin
