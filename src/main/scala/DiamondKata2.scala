package net.rosien.ocscala

trait ReverseTail[A] {
  def rtail(a: A): A
}

object ReverseTail {
  implicit object StringReverseTail extends ReverseTail[String] {
    def rtail(a: String): String = a.reverse.tail
  }

  implicit def ListReverseTail[A]: ReverseTail[List[A]] =
    new ReverseTail[List[A]] {
      def rtail(a: List[A]): List[A] = a.reverse.tail
    }
}

object DiamondKata2 {
  import scalaz._
  import scalaz.std.list._
  import scalaz.std.string._

  def diamond(c: Char): List[String] =
    appendReversedTail(
      DiamondKata.fromAUntil(c)
        .zipWithIndex
        .map(DiamondKata.pad(c - 'A').tupled)
        .map(appendReversedTail[String]))

  // ABC => ABCBA
  private def appendReversedTail[A](a: A)(implicit M: Monoid[A], R: ReverseTail[A]): A =
    M.append(a, R.rtail(a))
}