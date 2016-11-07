package net.rosien

package object ocscala {
  import org.scalacheck._

  val diamond =
    """|
       |     A
       |    B B
       |   C   C
       |  D     D
       | E       E
       |F         F
       | E       E
       |  D     D
       |   C   C
       |    B B
       |     A
    """.stripMargin

  ///////////

  val propConcatLists =
    Prop.forAll { (l1: List[Int], l2: List[Int]) =>
      l1.size + l2.size == (l1 ::: l2).size
    }

  val propSqrt =
    Prop.forAll { (n: Int) =>
      scala.math.sqrt(n * n) == n
    }

  ///////////

  object StringSpecification extends Properties("String") {
    import Prop.forAll

    property("startsWith") = forAll { (a: String, b: String) =>
      (a+b).startsWith(a)
    }

    property("endsWith") = forAll { (a: String, b: String) =>
      (a+b).endsWith(b)
    }

    property("substring") = forAll { (a: String, b: String) =>
      (a+b).substring(a.length) == b
    }

    property("substring") = forAll { (a: String, b: String, c: String) =>
      (a+b+c).substring(a.length, a.length+b.length) == b
    }
  }

  ///////////

  import org.scalacheck.Shapeless._

  case class Nerb(i: Int, s: String)

  val genNerb: Gen[Nerb] =
    for {
      i <- Gen.choose(1, 10)
      s <- Gen.alphaStr
    } yield Nerb(i, s)

  val propNerb =
    Prop.forAll { (nerb: Nerb) =>
      true
    }
}
