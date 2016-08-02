package apply

import org.scalatest.{Matchers, WordSpec}

import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 7. 25..
  */
class ApplySpec extends WordSpec with Matchers {

  "apply" should {
    val intToString: Int ⇒ String = _.toString
    val double: Int ⇒ Int = _ * 2
    val addTwo: Int ⇒ Int = _ + 2

    "map" in {
      Apply[Option].map(Some(1))(intToString) should be(Some("1"))
      Apply[Option].map(Some(1))(double) should be(Some(2))
      Apply[Option].map(None)(double) should be(None)
    }

    "compose" in {
      val listOpt = Apply[List] compose Apply[Option]
      val plusOne = (x: Int) ⇒ x + 1
      listOpt.ap(List(Some(plusOne)))(List(Some(1), None, Some(3))) should be()
    }

    "ap" in {
      Apply[Option].ap(Some(intToString))(Some(1)) should be()
      Apply[Option].ap(Some(double))(Some(1)) should be()
      Apply[Option].ap(Some(double))(None) should be()
      Apply[Option].ap(None)(Some(1)) should be()
      Apply[Option].ap(None)(None) should be()
    }
  }
}
