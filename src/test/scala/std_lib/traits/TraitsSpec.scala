package std_lib.traits

/**
  * Created by Harley on 2016. 12. 14..
  */
case class Event(name: String)

trait EventListener {
  def listen(event: Event): String
}

class MyListener extends EventListener {
  def listen(event: Event): String = {
    event match {
      case Event("Moose Stampede") ⇒ "An unfortunate moose stampede occurred"
      case _ ⇒ "Nothing of importance occurred"
    }
  }
}

class OurListener

class YouAndMeListener extends OurListener with EventListener {
  def listen(event: Event): String = {
    event match {
      case Event("Woodchuck Stampede") ⇒ "An unfortunate woodchuck stampede occurred"
      case _ ⇒ "Nothing of importance occurred"
    }
  }
}