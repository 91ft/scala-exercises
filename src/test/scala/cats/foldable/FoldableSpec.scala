package cats.foldable

import org.scalatest.{Matchers, WordSpec}
import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 8. 11..
  */
class FoldableSpec extends WordSpec with Matchers {

  "foldable" should {

    "foldLeft" in {
      Foldable[List].foldLeft(List(1, 2, 3), 0)(_ + _) should be(6)
      Foldable[List].foldLeft(List("a", "b", "c"), "")(_ + _) should be("abc")
    }

    "foldRight" in {
      val lazyResult = Foldable[List].foldRight(List(1, 2, 3), Now(0))((x, rest) ⇒ Later(x + rest.value))
      lazyResult.value should be()
    }

    "fold" in {
      Foldable[List].fold(List("a", "b", "c")) should be()
      Foldable[List].fold(List(1, 2, 3)) should be()
    }

    "foldMap" in {
      Foldable[List].foldMap(List("a", "b", "c"))(_.length) should be()
      Foldable[List].foldMap(List(1, 2, 3))(_.toString) should be()
    }

    "foldK" in {
      Foldable[List].foldK(List(List(1, 2), List(3, 4, 5))) should be()
      Foldable[List].foldK(List(None, Option("two"), Option("three"))) should be()
    }

    "find" in {
      Foldable[List].find(List(1, 2, 3))(_ > 2) should be()
      Foldable[List].find(List(1, 2, 3))(_ > 5) should be()
    }

    "exist" in {
      Foldable[List].exists(List(1, 2, 3))(_ > 2) should be()
      Foldable[List].exists(List(1, 2, 3))(_ > 5) should be()
    }

    "forall" in {
      Foldable[List].forall(List(1, 2, 3))(_ <= 3) should be()
      Foldable[List].forall(List(1, 2, 3))(_ < 3) should be()
    }

    "tolist" in {
      Foldable[List].toList(List(1, 2, 3)) should be()
      Foldable[Option].toList(Option(42)) should be()
      Foldable[Option].toList(None) should be()
    }

    "filter" in {
      Foldable[List].filter_(List(1, 2, 3))(_ < 3) should be()
      Foldable[Option].filter_(Option(42))(_ != 42) should be()
    }

    "traverse" in {
      import cats.std.all._
      import cats.data.Xor

      def parseInt(s: String): Option[Int] =
        Xor.catchOnly[NumberFormatException](s.toInt).toOption

      Foldable[List].traverse_(List("1", "2", "3"))(parseInt) should be()
      Foldable[List].traverse_(List("a", "b", "c"))(parseInt) should be()
    }

    "compose" in {
      val FoldableListOption = Foldable[List].compose[Option]
      FoldableListOption.fold(List(Option(1), Option(2), Option(3), Option(4))) should be()
      FoldableListOption.fold(List(Option("1"), Option("2"), None, Option("3"))) should be()
    }

    "more foldable methods" in {
      Foldable[List].isEmpty(List(1, 2, 3)) should be()
      Foldable[List].dropWhile_(List(1, 2, 3))(_ < 2) should be()
      Foldable[List].takeWhile_(List(1, 2, 3))(_ < 2) should be()
    }
  }
}
