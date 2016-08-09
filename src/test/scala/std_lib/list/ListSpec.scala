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
      (a eq b) should be(false)
      (a == b) should be(true)
    }

    "func" in {
      val a = List(1, 3, 5, 7, 9)

      a.length should equal(5)
      a.reverse should equal(List(9,7,5,3,1))
      a.map { v ⇒ v * 2 } should equal(List(2,6,10,14,18))
      a.filter { v ⇒ v % 3 == 0 } should equal(List(3,9))
    }
  }
}
