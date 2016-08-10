package cats.monad

import org.scalatest.{Matchers, WordSpec}

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


  }
}
