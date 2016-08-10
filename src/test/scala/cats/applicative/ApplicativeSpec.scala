package cats.applicative

import org.scalatest.{Matchers, WordSpec}

import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 8. 2..
  */
class ApplicativeSpec extends WordSpec with Matchers {

  "applicative" should {
    "pure" in {
      Applicative[Option].pure(1) should be(Option(1))
      Applicative[List].pure(1) should be(List(1))
    }

    "compose" in {
      (Applicative[List] compose Applicative[Option]).pure(1) should be(List(Option(1)))
    }

    "functors and monads" in {
      Monad[Option].pure(1) should be(Option(1))
      Applicative[Option].pure(1) should be(Option(1))
    }
  }
}
