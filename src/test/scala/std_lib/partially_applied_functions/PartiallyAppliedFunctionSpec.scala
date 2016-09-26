package std_lib.partially_applied_functions

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 9. 21..
  */
class PartiallyAppliedFunctionSpec extends WordSpec with Matchers {

  "partially applied function" should {

    "basic" in {
      def sum(a: Int, b: Int) = a + b

      val add1 = sum(1, _ : Int)
      add1(5) shouldBe 6

      // 곱하기
      def multiply(a: Int, b: Int) : Int = ???

      val doubled : Int => Int = ???
      doubled(5) shouldBe 10
    }

    "curried" in {
      // _ 대신에...
      def multiply2(a: Int)(b: Int) : Int = ???

      val doubled2 : Int => Int = ???
      doubled2(5) shouldBe 10
    }

    "curried 2" in {
      // _ 대신에...
      def multiply3(a: Int) = (b: Int) => ???

      val doubled3 : Int => Int = ???
      doubled3(5) shouldBe 10
    }

    "applyList" in {
      // 응용 : 함수를 파라미터로
      def applyList(func: (Int) => (Int))(list: List[Int]) : List[Int] = ???

      // applyList를 활용해서 리스트의 모든 값을 2배로 늘리는 함수
      // List(1,2,3)를 받으면 List(2,4,6)를 리턴
      val doubledList : (List[Int] => List[Int]) = ???

      doubledList(List(1,2,3)) shouldBe List(2,4,6)
    }

    "paging" in {
      // 핫딜을 10개 가져오려고 했으나 9개 밖에 안된다
      val hotdeals : List[Item] = getHotdeal("타입", "정상", 10)
      // 모자란 개수를 더 가져온다
      val add_hotdeals = getHotdeal("타입", "정상", 10 - hotdeals.size)
      // 합쳐서 반환한다
      val sumHotdeals = hotdeals ::: add_hotdeals
      sumHotdeals.size shouldBe 10

      // 상품을 10개 가져오려고 했으나 9개 밖에 안된다
      val brandItems : List[Item] = getBrandItem(true, "정상", 10)
      // 모자란 개수를 더 가져온다
      val add_brandItems = getBrandItem(true, "정상", 10 - brandItems.size)
      // 합쳐서 반환한다
      val sumBrandItems = brandItems ::: add_brandItems
      sumBrandItems.size shouldBe 10
    }

    "auto paging" in {
      // n만큼 상품 불러오기
      def autoPaging[T](func : Int => List[T], count : Int) = {
        val list1 = func(count)
        val list2 = func(count - list1.size)
        list1 ::: list2
      }

      val pagingHotdealFunction = ???
      val result : List[Item] = ???
      result.size shouldBe 10
    }

    case class Item(id : Int, name : String)
    def getHotdeal(templateType : String, status: String, n : Int) = (0 until n).filterNot(_ == 2).map(i => Item(i, s"${i} 상품명")).toList
    def getBrandItem(special : Boolean, status : String, n : Int) = (0 until n).filterNot(_ == 3).map(i => Item(i, s"${i} 상품명")).toList
  }
}
