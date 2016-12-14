package std_lib.traits

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by Harley on 2016. 12. 14..
  */
class TraitsTest extends WordSpec with Matchers {

  // Trait?  https://goo.gl/uVFzWk
  // Moose Stampede?  https://goo.gl/aK53sC
  // Woodchuck? https://goo.gl/Lz1w3e

  "Traits Practice" should {

    "extends test" in {
      val evt = Event("Moose Stampede")
      val myListener = new MyListener
      myListener.listen(evt) should be(
        "An unfortunate moose stampede occurred"
      )
    }

    "with test" in {
      val evt = Event("Woodchuck Stampede")
      val youAndMeListener = new YouAndMeListener
      youAndMeListener.listen(evt) should be ("An unfortunate woodchuck stampede occurred")
    }

    "isInstanceOf test" in {
      val myListener = new MyListener

      myListener.isInstanceOf[MyListener] should be(true)
      myListener.isInstanceOf[OurListener] should be(false)
      myListener.isInstanceOf[EventListener] should be(true)
      myListener.isInstanceOf[Any] should be(true)
      myListener.isInstanceOf[AnyRef] should be(true)

      val youAndMeListener = new YouAndMeListener
      youAndMeListener.isInstanceOf[OurListener] should be(true)
      youAndMeListener.isInstanceOf[EventListener] should be(true)
      youAndMeListener.isInstanceOf[Any] should be(true)
      youAndMeListener.isInstanceOf[AnyRef] should be(true)

    }
  }
}
