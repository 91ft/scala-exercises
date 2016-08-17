package cats.foldable

import cats.Foldable
import org.scalatest.{Matchers, WordSpec}
import cats.std.list.listInstance

/**
  * Created by karellen on 2016. 8. 11..
  */
class CustomFoldableSpec extends WordSpec with Matchers {

  "foldable" should {

    "test" in {
      Foldable[List].foldLeft(List[Int](), 0)((acc, item) => item)
      val list = List(1,2,3,4,5)

      val sum = Foldable[List].foldLeft(list, 0)((acc, item) => acc + item)
      sum shouldBe 15

      val filtered = Foldable[List].foldLeft(list, List[Int]())((filter, item) => if (item % 2 == 0) item :: filter else filter).sorted
      filtered shouldBe list.filter(_ % 2 == 0)

      def myMap(list : List[Int])(f : Int => Int) : List[Int] = {
        Foldable[List].foldLeft(list, List[Int]()) {
          case (acc, x) => acc ::: List(f(x))
        }
      }

      myMap(list)(x => x + 10) shouldBe list.map(_ + 10)
    }
  }
}
