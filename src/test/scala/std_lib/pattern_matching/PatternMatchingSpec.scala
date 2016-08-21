package std_lib.pattern_matching

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 8. 22..
  */
class PatternMatchingSpec extends WordSpec with Matchers {

  "Pattern Matching" should {

    "basic" in {

      def func1(num : Int) : String = ???

      func1(1) shouldBe "one"
      func1(2) shouldBe "other" // 1외의 아무 숫자나 넣었을 때


      def func2(num : Int) : Any = ???

      func2(1) shouldBe "one"
      func2(2) shouldBe 2 // 1외의 아무 숫자나 넣었을 때
    }

    "type" in {

      def func(obj : Any) : String = ???

      func("str") shouldBe "string" // 문자열을 넣으면
      func(1) shouldBe "number" // 숫자를 넣으면
    }

    "type2" in {

      trait Link
      class Facebook extends Link {
        def getID() = "아이디"
      }
      class Kakao extends Link {
        def getName() = "본명"
      }
      class KakaoStrory extends Link {
        def getNickName() = "닉네임"
      }

      def getName(link : Link) : String = ???

      getName(new Facebook) shouldBe "아이디"
    }


  }

}
