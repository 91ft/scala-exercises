package std_lib.list

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by karellen on 2016. 8. 10..
 */
class ListSpec extends WordSpec with Matchers {

  "list" should {
    "eq" in {
      val a = List(1, 2, 3)
      val b = List(1, 2, 3)
      (a eq b) should be()
      (a == b) should be()
    }

    "eq Nil" in {
      val a: List[String] = Nil
      val b: List[Int] = Nil

      (a == Nil) should be()
      (a eq Nil) should be()
      (b == Nil) should be()
      (b eq Nil) should be()
      (a == b) should be()
      (a eq b) should be()
    }

    "head, tail" in {
      val a = List(1, 2, 3)
      a.headOption should equal()
      a.tail should equal()
    }

    "by position" in {
      val a = List(1, 3, 5, 7, 9)
      a(0) should equal()
      a(2) should equal()
      a(4) should equal()

      intercept[IndexOutOfBoundsException] {
        println(a(5))
      }
    }

    "immutable" in {
      val a = List(1, 3, 5, 7, 9)
      val b = a.filterNot(v ⇒ v == 5) // remove where value is 5

      a should equal()
      b should equal()
    }

    "func" in {
      val a = List(1, 3, 5, 7, 9)

      a.length should equal()
      a.reverse should equal()
      a.map { v ⇒ v * 2 } should equal()
      a.filter { v ⇒ v % 3 == 0 } should equal()
    }

    "_" in {
      val a = List(1, 2, 3)

      a.map { _ * 2 } should equal()
      a.filter { _ % 2 == 0 } should equal()

      a.map(_ * 2) should equal()
      a.filter(_ % 2 != 0) should equal()
    }

    "reduce" in {
      val a = List(1, 3, 5, 7)
      a.reduceLeft(_ + _) should equal()
      a.reduceLeft(_ * _) should equal()
    }

    "fold" in {
      val a = List(1, 3, 5, 7)
      // NOTE: foldLeft uses a form called currying that we will explore later
      a.foldLeft(0)(_ + _) should equal()
      a.foldLeft(10)(_ + _) should equal()
      a.foldLeft(1)(_ * _) should equal()
      a.foldLeft(0)(_ * _) should equal()
    }

    "::" in {
      val d = Nil
      val c = 3 :: d
      val b = 2 :: c
      val a = 1 :: b

      a should be(List(1, 2, 3))
      a.tail should be()
      b.tail should be()
      c.tail should be()
    }
  }
}
