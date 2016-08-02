package std_lib.tuples

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by karellen on 2016. 8. 3..
 */
class TuplesSpec extends WordSpec with Matchers {

  "tuple" should {
    "create" in {
      val a = ("apple", "dog")
      val b = new Tuple2("apple", "dog")
    }
  }
}
