package cats.monoid

import org.scalatest.{Matchers, WordSpec}

import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 7. 20..
  */
class MonoidSpec extends WordSpec with Matchers {

  "cats/monoid" should {
    "empty" in {
      Monoid[String].empty should be("")
    }

    "combineAll[String] (a, b)" in {
      Monoid[String].combineAll(List("a", "b", "c")) should be("abc")
      Monoid[String].combineAll(List()) should be("")
    }

    "combineAll[Map] (a, b)" in {
      Monoid[Map[String, Int]].combineAll(List(Map("a" → 1, "b" → 2), Map("a" → 3))) should be(Map("b" -> 2, "a" -> 4))
      Monoid[Map[String, Int]].combineAll(List()) should be(Map())
    }

    "foldMap[Int]" in {
      val l = List(1, 2, 3, 4, 5)
      l.foldMap(identity) should be(15)
      l.foldMap(i ⇒ i.toString) should be("12345")
    }

    "foldMap[Int, String]" in {
      val l2 = List(1, 2, 3, 4, 5)
      l2.foldMap(i ⇒ (i, i.toString)) should be((15, "12345"))
    }
  }
}
