package std_lib.pattern_matching

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 8. 22..
  */
class PatternMatchingSpec extends WordSpec with Matchers {

  "Pattern Matching" should {

    "basic" in {

      def func1(num : Int) : String = num match {
        case 1 => "one"
        case _ => "other"
      }

      func1(1) shouldBe "one"
      func1(2) shouldBe "other" // 1외의 아무 숫자나 넣었을 때

      def func2(num : Int) : Any = num match {
        case 1 => "one"
        case _ => "dd"
      }

      func2(1) shouldBe "one"
      func2(66) shouldBe 66 // 1외의 아무 숫자나 넣었을 때
    }

    "type" in {

      def func(obj : Any) : String = obj match {
        case n : String => "string"
        case n : Int => "number"
      }

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

      val a = Some(3) // Option[Int]
      val bb: Any = a.getOrElse("d")
      
      def getName(link : Link) : Option[String] = link match {
        case f : Facebook => Some(f.getID())
        case s : KakaoStrory => Some(s.getNickName())
        case k : Kakao => Some(k.getName())
        case _ => None
      }

      getName(new Facebook) shouldBe "아이디"
    }


  }

}
