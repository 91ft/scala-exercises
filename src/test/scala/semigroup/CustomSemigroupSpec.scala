package semigroup

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 7. 18..
  */
class CustomSemigroupSpec extends WordSpec with Matchers {

  "custom semigroup" in {
    import cats.Semigroup

    case class Foo(a : Int,  b: String)

    implicit val fooSemigroup = new Semigroup[Foo] {
      override def combine(x: Foo, y: Foo): Foo = Foo(x.a + y.a, x.b + y.b)
    }

    val foo1 = Foo(1, "a")
    val foo2 = Foo(2, "b")
    Semigroup.combine(foo1, foo2) shouldBe Foo(3, "ab")

    import cats.implicits._
    foo1 |+| foo2 shouldBe Foo(3, "ab")
  }
}
