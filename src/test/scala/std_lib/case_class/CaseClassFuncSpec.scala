package std_lib.case_class

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen on 2016. 8. 29..
  */
class CaseClassFuncSpec extends WordSpec with Matchers {

  "case class" should {

    "class vs case class" in {

      class Person1(id : Int, name : String, tel : String)
      case class Person2(id : Int, name : String, tel : String)


      // 생성
      val person1 : Person1 = ???
      val person2 : Person2 = ???

      // 변수 접근
      //person1.id
      //person2.id

      val personSame1 : Person1 = ???
      val personSame2 : Person2 = ???

      // equals
      person1 == personSame1 shouldBe ???
      person2 == personSame2 shouldBe ???

      // copy
      val copyPerson1 : Person1 = ???
      val copyPerson2 : Person2 = ???
    }

    "pattern match" in {
      case class Person(id : Int, name : String)

      val person = Person(1, "박보검")

      val name = person match {
        case Person(id, name) => name
      }

      name shouldBe "박보검"
    }

    "class's pattern match" in {

      class Person(val id : Int, val name : String, val lastAccess: Option[LastAccess])
      class LastAccess(val day : Int, val favorTab : Option[FavorTab])
      class FavorTab(val tab : Int)

      val person1 = new Person(1, "박보검", Some(new LastAccess(1, Some(new FavorTab(2)))))
      val person2 = new Person(2, "김수현", Some(new LastAccess(3, None)))

      showTab(person1) shouldBe 2
      showTab(person2) shouldBe 0

      // lastAccess 가 없으면 tab은 0
      // lastAccess 가 있지만, favorTab이 없으면 tab은 0
      def showTab(person : Person) : Int = ???
    }

    "case class's pattern match" in {

      case class Person(id : Int, name : String, lastAccess: Option[LastAccess])
      case class LastAccess(day : Int, favorTab : Option[FavorTab])
      case class FavorTab(tab : Int)

      val person1 = ???
      val person2 = ???

      showTab(person1) shouldBe 2
      showTab(person2) shouldBe 0

      // lastAccess 가 없으면 tab은 0
      // lastAccess 가 있지만, favorTab이 없으면 tab은 0
      def showTab(person : Person) : Int = ???

    }
  }
}
