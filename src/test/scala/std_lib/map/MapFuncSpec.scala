package std_lib.map

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by karellen on 2016. 8. 14..
 */
class MapFuncSpec extends WordSpec with Matchers {

  "map" should {

    "basic" in {
      val map = Map("a" -> 1, "b" -> 2, "c" -> 2, "c" -> 3)

      val size : Int = ???
      size shouldBe 3

      val keys: Iterable[String] = ???
      keys shouldBe Set("a", "b", "c")

      val values: Iterable[Int] = ???
      values.toList shouldBe List(1, 2, 3)

      val find: Int = ???
      find shouldBe 1

      val findOption: Option[Int] = ???
      findOption shouldBe Some(1)
    }

    "값 추가, 삭제" in {
      val map = Map("a" -> 1, "b" -> 2, "c" -> 3)

      val add: Map[String, Int] = ???
      val delete: Map[String, Int] = ???

      add shouldBe Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5)
      delete shouldBe Map("a" -> 1)
    }

    "mixed type map" in {
      val map = Map("a" -> 1, 2 -> "b", true -> 3)

      map("a") shouldBe 1
      map(true) shouldBe 3

      // val map = Map() // tuple로 생성
      // map.head
    }
  }
}
