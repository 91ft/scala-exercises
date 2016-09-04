package std_lib.range

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.Range.Inclusive

/**
  * Created by karellen on 2016. 9. 4..
  */
class RangeSpec extends WordSpec with Matchers {

  "Range" should {

    "basic" in {
      val list = Range(0, 10)

      println(list)

      val size: Int = ???
      size shouldBe 10

      val elem0: Int = ???
      elem0 shouldBe 0

      val from1To9: Range = ???
      from1To9 shouldBe Range(1, 10)

      val elem9: Int = ???
      elem9 shouldBe 9

      val from0To9: Range = ???
      from0To9 shouldBe Range(0, 9)

      val list0_2_4_6_8 : Range = ???
      list0_2_4_6_8 shouldBe List(0, 2, 4, 6, 8)
    }

    "func" in {
      val from0To9_1: Range = ???
      from0To9_1 shouldBe Range(0, 10)

      val from0To9_2: Range = ???
      from0To9_2 shouldBe Range(0, 10)
    }

    "convert to list" in {
      val list : List[Int] = ???
    }
  }
}
