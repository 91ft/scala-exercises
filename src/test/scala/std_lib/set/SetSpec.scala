package std_lib.set

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by karellen on 2016. 8. 14..
 */
class SetSpec extends WordSpec with Matchers {

  "set" should {

    "basic" in {
      val mySet = Set("Michigan", "Ohio", "Wisconsin", "Michigan")
      mySet.size should be(3)
    }

    "add, delete" in {
      val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      val aNewSet = mySet + "Illinois"

      aNewSet.contains("Illinois") should be(true)
      mySet.contains("Illinois") should be(false)
    }

    "intersect" in {
      val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
      val aNewSet = mySet1 intersect mySet2
      // NOTE: Scala 2.7 used **, deprecated for & or intersect in Scala 2.8

      aNewSet.equals(Set("Michigan", "Wisconsin")) should be(true)
    }

    "union" in {
      val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
      val aNewSet = mySet1 union mySet2 // NOTE: You can also use the "|" operator

      aNewSet.equals(Set("Michigan", "Wisconsin", "Ohio", "Iowa", "Minnesota")) should be(true)
    }

    "subset" in {
      val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
      val mySet3 = Set("Wisconsin", "Michigan")

      mySet2 subsetOf mySet1 should be(false)
      mySet3 subsetOf mySet1 should be(true)
    }

    "diff" in {
      val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      val mySet2 = Set("Wisconsin", "Michigan")
      val aNewSet = mySet1 diff mySet2 // Note: you can use the "&~" operator if you *really* want to.

      aNewSet.equals(Set("Ohio", "Iowa")) should be(true)
    }
  }
}
