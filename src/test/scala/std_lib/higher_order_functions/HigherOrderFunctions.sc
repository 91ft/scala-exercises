def defFunc = (x: Int) => x + 1

val valFunc = (x: Int) => x + 1

val newValFunc = new Function1[Int, Int] {
  def apply(v1: Int): Int = v1 + 1
}

//def defNoting: Int => Boolean = ???
val valNoting : Int => Boolean = ???