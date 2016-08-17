package std_lib.list

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.Range.Inclusive
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
      val slist : List[Int] = List(1,2,3) // == List.apply(1,2,3)
      slist shouldBe List(1, 2, 3)

      val _0To10 = (0 to 10)
      _0To10 shouldBe List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    "변형하다" in {
      val list = List(1, 2, 3, 4, 5)

      val firstAdd : List[Int] = 0 :: list // 0 +: list
      firstAdd shouldBe List(0, 1, 2, 3, 4, 5)

      val lastAdd : List[Int] = list :+ 6
      lastAdd shouldBe List(1, 2, 3, 4, 5, 6)

      val lastAddList : List[Int] = list ::: List(6,7)
      lastAddList shouldBe List(1, 2, 3, 4, 5, 6, 7)
    }

    "접근하다 1" in {
      val list = List()

      val secondItem : Int = list(1) // list.apply(1)
      secondItem shouldBe 2

      val firstItem : Int = list.head // list.tail
      firstItem shouldBe 1

      val lastItem : Int = list.last // list.init
      lastItem shouldBe 5

      val exceptFirst : List[Int] = list.tail
      exceptFirst shouldBe List(2, 3, 4, 5)

      val exceptLast : List[Int] = list.init
      exceptLast shouldBe List(1, 2, 3, 4)
    }

    "접근하다 2" in {
      val list = List(1,2,3,4)

      val takeList : List[Int] = list.take(2)
      takeList shouldBe List(1, 2)

      val dropList : List[Int] = list.drop(2)
      dropList shouldBe List(3, 4)

      val firstItem : Option[Int] = list.headOption
      firstItem shouldBe Some(1)
      //Option = Some, None

      val thirdItem : Option[Int] = list.drop(2).headOption
      thirdItem shouldBe Some(3)

      val lastItem : Option[Int] = list.drop(3).headOption
      lastItem shouldBe Some(4)
    }

    "필터링하다" in {
      val list = List(1, 2, 3, 4, 5)

      val even : List[Int] = list.filter { i => i % 2 == 0 }
      even shouldBe List(2, 4)

      val odd : List[Int] = list.filterNot { i => i % 2 == 0 }
      odd shouldBe List(1, 3, 5)
    }

    "변형하다" in {
      val list = List(1, 2, 3, 4, 5)

      val doubled : List[Int] = list.map(i => i * 2)
      doubled shouldBe List(2, 4, 6, 8, 10)
    }

    "sum, max" in {
      val list = List(1, 2, 3, 4, 5)

      val sum : Int = list.reduce((sum, item) => sum + item)
      // reduceLeft, reduceRight
      sum shouldBe 15

      val max : Int = list.reduce((max, item) => Math.max(max, item))
      max shouldBe 5
    }

  }
}
