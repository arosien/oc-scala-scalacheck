package net.rosien.ocscala

import org.scalatest.FlatSpec

trait Fixture {
  lazy val lines = DiamondKata.diamond('F')
}

class DiamondKataUnitTest extends FlatSpec {
  "DiamondKata.diamond" should "have odd number of lines" in new Fixture {
    assertResult(1)(lines.size % 2)
  }

  "DiamondKata.diamond" should "have two characters for each inner line" in new Fixture {
    def middle[A](l: List[A]): List[A] = l.tail.dropRight(1)
    def countNonSpaces(s: String): Int = s.filterNot(_.isSpaceChar).size

    for {
      line <- middle(lines)
    } assertResult(2)(countNonSpaces(line))
  }

  "DiamondKata.diamond" should "be mirrored over the center line" in new Fixture {
    assertResult(lines)(lines.reverse)
  }
}