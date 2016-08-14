package std_lib.set

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by karellen on 2016. 8. 14..
 */
class SetFuncSpec extends WordSpec with Matchers {

  "set" should {

    "basic" in {
      val set = Set("a", 1, true, "a")

      val size : Int = ???
      size shouldBe 3

      val contains: Boolean = ???
      contains shouldBe true

      val apply: Boolean = ???
      apply shouldBe true
    }

    "add, delete" in {
      val set = Set(1,2,3)

      val add: Set[Int] = ???
      add shouldBe Set(1,2,3,4,5)

      val delete: Set[Int] = ???
      delete shouldBe Set(1)
    }

    "useful functions" in {
      val set1 = Set(1,2,3)
      val set2 = Set(2,3,4,5)

      val both: Set[Int] = ???
      both shouldBe Set(2, 3)

      val sum: Set[Int] = ???
      sum shouldBe Set(1, 2, 3, 4, 5)

      val sub1: Boolean = ???
      sub1 shouldBe false

      val sub2: Boolean = ???
      sub2 shouldBe true

      val sub3: Set[Int] = ???
      sub3 shouldBe Set(4, 5)
    }
  }
}
