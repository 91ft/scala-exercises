package std_lib.list

import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

/**
 * Created by karellen on 2016. 8. 10..
 */
class ListFuncSpec extends WordSpec with Matchers {

  "리스트" should {
    "생성하다" in {
      // Java 버전
      var jList = new mutable.ListBuffer[Int]()
      jList.append(1)
      jList.append(2)
      jList.append(3)
      jList shouldBe List(1, 2, 3)

      // Scala 버전
      val slist = List(1, 2, 3)
      slist shouldBe List(1, 2, 3)
    }

    "접근하다" in {
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

    "for-yield" in {
      val list = List(1, 2, 3, 4, 5)

      // Java 버전
      // for (int i = 0 ; i < list.size() ; i++) print(list.get(i))
      // for (int item : list) print(list.get(i))

      // Scala 버전
      for { i <- (0 until list.size) } yield print(list(i))
      for { item <- list } yield print(item)
      list.map(item => print(item))
    }
  }
}
