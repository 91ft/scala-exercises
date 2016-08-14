package std_lib.map

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by karellen on 2016. 8. 14..
 */
class MapSpec extends WordSpec with Matchers {

  "map" should {

    "init" in {
      val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")
      myMap.size should be(3)
    }

    "add" in {
      val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")
      val aNewMap = myMap + ("IL" → "Illinois")
      aNewMap.contains("IL") should be(true)
    }

    "head, last" in {
      val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")

      val mapValues = myMap.values
      mapValues.size should be(3)
      mapValues.head should be("Michigan")

      val lastElement = mapValues.last
      lastElement should be("Wisconsin")
    }

    "mixed type" in {
      val myMap = Map("Ann Arbor" → "MI", 49931 → "MI")
      myMap("Ann Arbor") should be("MI")
      myMap(49931) should be("MI")
    }

    "default value" in {
      val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
      intercept[NoSuchElementException] { myMap("TX") }
      myMap.getOrElse("TX", "missing data") should be("missing data")

      val myMap2 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa") withDefaultValue "missing data"
      myMap2("TX") should be("missing data")
    }

    "remove" in {
      val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
      val aNewMap = myMap -- List("MI", "OH")

      aNewMap.contains("MI") should be(false)
      myMap.contains("MI") should be(true)

      aNewMap.contains("WI") should be(true)
      aNewMap.size should be(2)
      myMap.size should be(4)
    }
  }
}
