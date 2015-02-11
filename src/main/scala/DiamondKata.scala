package net.rosien.ocscala

object DiamondKata {
  def diamond(c: Char): List[String] =
    appendReversedTail(
      fromAUntil(c)
        .zipWithIndex
        .map(pad(c - 'A').tupled)
        .map(prefix => prefix + prefix.reverse.tail))

  private def appendReversedTail[A](as: List[A]): List[A] =
    as ::: as.reverse.tail

  private[ocscala] def fromAUntil(c: Char): List[Char] =
    ('A' to c).toList

  private[ocscala] def pad(width: Int) = (c: Char, lineNumber: Int) => {
    val leftPadding = " " * (width - lineNumber)
    val rightPadding = " " * lineNumber

    s"$leftPadding$c$rightPadding"
  }
}