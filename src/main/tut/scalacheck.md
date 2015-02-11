# ScalaCheck

```tut:silent
import org.scalacheck._
```

## How many tests are enough?

## Examples vs. Properties

* Magic numbers
* Ad-hoc test fixtures
* 1 test per variation: copy-paste disease

## Example code to check

```tut
"\n" + net.rosien.ocscala.DiamondKata.diamond('F').mkString("\n")
```

## `org.scalacheck.Prop`

```tut:silent
val propConcatLists =
  Prop.forAll { (l1: List[Int], l2: List[Int]) =>
    l1.size + l2.size == (l1 ::: l2).size
  }
```

```tut
propConcatLists.check
```

```tut:silent
val propSqrt =
  Prop.forAll { (n: Int) =>
    scala.math.sqrt(n * n) == n
  }
```

```tut
propSqrt.check
```

## `org.scalacheck.Gen`

## `org.scalacheck.Arbitrary`

## Hints for property definitions

* "different paths, same destination" - commutativity, associativity, etc.
* "there and back again" - operations with their inverse: add/subtract, write/read, set/get
* "some things never change" - invariants after transformation: `map`/collection-size, `sort`/collection-contents
* "the more things change, the more they stay the same" - idempotency, `distinct(distinct(xs)) == distinct(xs)`
* "solve a smaller problem first" - induction properties
* "hard to prove, easy to verify"
* "test oracle" - compare vs. alternate version

## Stateful testing

## Fancy stuff

Woah! No `Arbitrary` instance required!

```tut
import shapeless.contrib.scalacheck._

case class Nerb(i: Int, s: String)

val propNerb =
  Prop.forAll { (nerb: Nerb) =>
    true
  }

propNerb.check
```

## References

* [scalacheck.org](http://www.scalacheck.org)
* [An introduction to property-based testing](http://fsharpforfunandprofit.com/posts/property-based-testing)
* [`shapeless-scalacheck` for automatically derived scalacheck typeclasses](https://github.com/typelevel/shapeless-contrib)

* [Stateful example](https://github.com/rickynils/scalacheck/tree/master/examples/commands-nix)
* [](https://github.com/NightRa/Reversi-AI/blob/master/src/test/scala/nightra/reversi/ai/AITest.scala)