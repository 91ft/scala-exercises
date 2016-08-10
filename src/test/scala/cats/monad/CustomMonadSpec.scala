package cats.monad

import org.scalatest.{Matchers, WordSpec}
import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 8. 9..
  */
class CustomMonadSpec extends WordSpec with Matchers {

  "monad" should {
    "foo monad instance" in {
      case class Foo[T](a : T)

      val fooInstance = new Monad[Foo] {
        override def pure[A](x: A): Foo[A] = Foo[A](x)
        override def flatMap[A, B](fa: Foo[A])(f: (A) => Foo[B]): Foo[B] = f(fa.a)
      }

      fooInstance.pure(3) shouldBe Foo(3)
      fooInstance.flatMap(Foo(3))((x : Int) => Foo(x.toString)) shouldBe Foo("3")
    }

    "option monad instance" in {
      val optionInstance = new Monad[Option] {
        override def pure[A](x: A): Option[A] = Option(x)
        override def flatMap[A, B](fa: Option[A])(f: (A) => Option[B]): Option[B] = fa match {
          case Some(n) => f(n)
          case None => None
        }
      }

      optionInstance.pure(3) shouldBe Option(3)
      optionInstance.flatMap(Option(3))((x : Int) => Option(x.toString)) shouldBe Option("3")
      optionInstance.flatMap(None)((x : Int) => Option(x.toString)) shouldBe None
    }
  }
}
