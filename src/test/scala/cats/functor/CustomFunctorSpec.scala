package cats.functor

import org.scalatest.{Matchers, WordSpec}

import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 7. 25..
  */
class CustomFunctorSpec extends WordSpec with Matchers {

  "custom cats.functor" should {

    "option" in {
      implicit val optionFunctor = new Functor[Option] {
        override def map[A, B](a: Option[A])(f: A => B): Option[B] = {
          a match {
            case Some(s) => f(s).some
            case None => None
          }
        }
      }
      optionFunctor.map(Option(2))(_ + 1) should be(Some(3))
    }
/*
    "list" in {
      implicit val listFunctor = new Functor[List] {
        override def map[A, B](a: List[A])(f: A => B): List[B] = {

        }
      }
      listFunctor.map(List(1, 2))(_ + 1) should be(List(2, 3))
    }
*/
    "my instance" in {
      case class Foo[T](t: T)

      import cats.syntax.functor._
      implicit val fooFunctor = new Functor[Foo] {
        override def map[A, B](a: Foo[A])(f: A => B): Foo[B] = Foo[B](f(a.t))
      }

      Functor[Foo].map(Foo[Int](1))(_ + 1) shouldBe Foo[Int](1).map(_ + 1)
    }

  }
}
