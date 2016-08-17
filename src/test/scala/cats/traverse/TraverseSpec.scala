package cats.traverse

import cats.{Applicative, Traverse}
import cats.data.Xor

import scala.concurrent.Future
import cats.std.list.listInstance
import cats.std.future.futureInstance
import cats.syntax.all._
import cats.std.option._
import org.scalatest.{Matchers, WordSpec}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by karellen on 2016. 8. 16..
  */
class TraverseSpec extends WordSpec with Matchers {

  "traverse" should {

    "test" in {
       // List(Option(1), Option(2), Option(3))
      List(Option(1), Option(2), Option(3)).traverse(identity) shouldBe Option(List(1,2,3))
      List(Option(1), Option(2), Option(3)).sequence shouldBe Option(List(1,2,3))


      val userIds = List(1, 2, 3, 4)
      case class User(id: Int, name: String)
      def getUser(id: Int): Future[User] = Future { User(id, s"name-$id") }

      userIds.map(getUser).map(_.map(println))
      userIds.map(getUser).sequence.map(println)

      val futureListUser = Applicative[Future].sequence(userIds.map(getUser))
      futureListUser.map(println)

      val list1: Future[List[User]] = Traverse[List].traverse(userIds)(getUser)
      val list2: Future[List[User]] = userIds.traverse(getUser)
    }
  }
}
