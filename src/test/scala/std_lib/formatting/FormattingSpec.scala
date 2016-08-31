package std_lib.formatting

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 8. 31..
  */
class FormattingSpec extends WordSpec with Matchers {

  "Formatting" should {

    "format" in {
      val id = 1
      val name = "박보검"

      "♥ %s ♥".format(name) shouldBe "♥ 박보검 ♥"

      val str : String = ???
      str.format(id, name) shouldBe "id = 1, name = 박보검"
    }

    "format" in {
      val id = 1
      val name = "박보검"

      s"♥ ${name} ♥" shouldBe "♥ 박보검 ♥"

      val str : String = ???
      str.format(id, name) shouldBe "id = 1, name = 박보검"
    }
  }
}
