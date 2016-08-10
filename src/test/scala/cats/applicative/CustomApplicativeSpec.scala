package cats.applicative

import org.scalatest.{Matchers, WordSpec}

import cats._
import cats.implicits._


/**
  * Created by karellen on 2016. 8. 4..
  */
class CustomApplicativeSpec extends WordSpec with Matchers {
  case class Foo[T](a: T)

  "CustomApplicative" should {
    "test" in {
      implicit val fooCustomApplicativeInstance = new Applicative[Foo] {
        override def pure[A](x: A): Foo[A] = Foo(x)
        override def ap[A, B](ff: Foo[(A) => B])(fa: Foo[A]): Foo[B] = Foo(ff.a(fa.a))
      }

      fooCustomApplicativeInstance.pure(1) should be(Foo(1))
      def func = Foo((x : Int) => x.toString)
      fooCustomApplicativeInstance.ap(func)(Foo(1)) should be(Foo("1"))
    }
  }
}
