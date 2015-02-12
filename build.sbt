scalaVersion := "2.11.4"

// No "test" scoping in order to write tests in the tutorial.
libraryDependencies ++=
  Seq(
    "org.scalacheck" %% "scalacheck"           % "1.12.0",
    "org.scalatest"  %% "scalatest"            % "2.2.1",
    "org.scalaz"     %% "scalaz-core"          % "7.1.0",
    "org.typelevel"  %% "shapeless-scalacheck" % "0.3")

initialCommands in console :=
  """|import net.rosien.ocscala._
     |import org.scalacheck._
     |
     |val repl = REPLesent(0, 0, "src/main/repl/scalacheck.txt")
     |import repl._
     |h
  """.stripMargin
