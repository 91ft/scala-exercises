package std_lib.example

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 8. 31..
  */
class MockPageServiceSpec extends WordSpec with Matchers {

  "page service" should {

    "getDeal" in {
      val service = new MockPageService
      service.getDeal().foreach(println)
    }
  }
}
