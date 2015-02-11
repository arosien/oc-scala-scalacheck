package net.rosien.ocscala

import org.scalacheck._

object DiamondKataProperties extends Properties("DiamondKata") {
  import Prop._

  property("oddNumberOfLines") =
    Prop.forAll(Gen.alphaUpperChar) { (c: Char) =>
      val lines = DiamondKata.diamond(c)

      s"${lines}" |: lines.size % 2 == 1
    }

  property("innerLinesHaveTwoChars") =
    Prop.forAll(Gen.alphaUpperChar) { (c: Char) =>
      val lines = DiamondKata.diamond(c)
      def middle[A](l: List[A]): List[A] = l.tail.dropRight(1)
      def countNonSpaces(s: String): Int = s.filterNot(_.isSpaceChar).size

      lines.mkString("\n") |: middle(lines).forall(countNonSpaces(_) == 2)
    }

  property("mirroredOverCenter") =
    Prop.forAll(Gen.alphaUpperChar) { (c: Char) =>
      val lines = DiamondKata.diamond(c)

      lines == lines.reverse
    }
}