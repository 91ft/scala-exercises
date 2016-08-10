package std_lib.list

import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

/**
 * Created by karellen on 2016. 8. 10..
 */
class ListFuncSpec extends WordSpec with Matchers {

  "리스트" should {
    "생성하다 1" in {
      // Java 버전
      var jList = new mutable.ListBuffer[Int]()
      jList.append(1)
      jList.append(2)
      jList.append(3)
      jList shouldBe List(1, 2, 3)

      // Scala 버전
      val slist : List[Int] = ???
      slist shouldBe List(1, 2, 3)

      val _0To10 : List[Int] = ???
      _0To10 shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    "생성하다 2" in {
      val list = List(1, 2, 3, 4, 5)

      val firstAdd : List[Int] = ???
      firstAdd shouldBe List(0, 1, 2, 3, 4, 5)

      val lastAdd : List[Int] = ???
      lastAdd shouldBe List(1, 2, 3, 4, 5, 6)

      val lastAddList : List[Int] = ???
      lastAddList shouldBe List(1, 2, 3, 4, 5, 6, 7)
    }

    "접근하다 1" in {
      val list = List(1, 2, 3, 4, 5)

      val secondItem : Int = ???
      secondItem shouldBe 2

      val firstItem : Int = ???
      firstItem shouldBe 1

      val lastItem : Int = ???
      lastItem shouldBe 5

      val exceptFirst : List[Int] = ???
      exceptFirst shouldBe List(2, 3, 4, 5)

      val exceptLast : List[Int] = ???
      exceptLast shouldBe List(1, 2, 3, 4)
    }

    "접근하다 2" in {
      val list = List(1, 2, 3, 4, 5)

      val takeList : List[Int] = ???
      takeList shouldBe List(1, 2)

      val dropList : List[Int] = ???
      dropList shouldBe List(3, 4)

      val firstItem : Option[Int] = ???
      firstItem shouldBe Some(2)

      val secondItem : Option[Int] = ???
      secondItem shouldBe Some(2)

      val lastItem : Option[Int] = ???
      lastItem shouldBe Some(2)

      val exceptFirst : List[Int] = ???
      exceptFirst shouldBe List(2, 3, 4, 5)

      // 이렇게 사용할 일은 없지만..
      val exceptLast : List[Int] = ???
      exceptLast shouldBe List(1, 2, 3, 4)
    }

    "필터링하다" in {
      val list = List(1, 2, 3, 4, 5)

      val even : List[Int] = ???
      even shouldBe List(2, 4)

      val odd : List[Int] = ???
      odd shouldBe List(1, 3, 5)
    }

    "변형하다" in {
      val list = List(1, 2, 3, 4, 5)

      val doubled : List[Int] = ???
      doubled shouldBe List(2, 4, 6, 8, 10)

      val added6 : List[Int] = ???
      added6 shouldBe List(1, 2, 3, 4, 5, 6)

      val added0 : List[Int] = ???
      added0 shouldBe List(0, 1, 2, 3, 4, 5)

      val addedList : List[Int] = ???
      addedList shouldBe List(1, 2, 3, 4, 5, 6, 7, 8)
    }

    "sum, max" in {
      val list = List(1, 2, 3, 4, 5)

      val sum : Int = ???
      sum shouldBe 15

      val max : Int = ???
      max shouldBe 5
    }

  }
}
