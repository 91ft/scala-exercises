package cats.monad

import org.scalatest.{Matchers, WordSpec}
import cats._
import cats.std.all._

/**
  * Created by karellen on 2016. 8. 4..
  */
class MonadSpec extends WordSpec with Matchers {

  "monad" should {
    "test" in {
      val func1: (Int) => String = (a : Int) => a.toString
      val func2: (Int) => Option[String] = (a : Int) => {
        if (a > 10) Some(a.toString)
        else None
      }

      val result1: Option[String] = Option[Int](1).map(func1)
      val result2: Option[Option[String]] = Option[Int](1).map(func2)
    }

    "ifM" in {
      Monad[Option].ifM(Option(true))(Option("truthy"), Option("falsy")) should be(Option("truthy"))
      Monad[List].ifM(List(true, false, true))(List(1, 2), List(3, 4)) should be(List(1, 2, 3, 4, 1, 2))
    }
  }
}
