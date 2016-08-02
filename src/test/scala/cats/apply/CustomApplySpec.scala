package cats.apply

import org.scalatest.{Matchers, WordSpec}

import cats._
import cats.implicits._

/**
  * Created by karellen on 2016. 7. 28..
  */
class CustomApplySpec extends WordSpec with Matchers {

  "cats/apply" should {
    "test" in {
      implicit val listApplyInstance = new Apply[List] {
        override def ap[A, B](ff: List[(A) => B])(fa: List[A]): List[B] = fa.flatMap(a => ff.map(f => f(a)))
        override def map[A, B](fa: List[A])(f: (A) => B): List[B] = fa.map(f)
      }

      println(listApplyInstance.ap(List((x : Int) => x.toString + "!", (x : Int) => x.toString + "?"))(List(1,2,3)))
    }
  }
}
