package std_lib.tuples

/**
  * Created by karellen on 2016. 8. 3..
  */

class STuple[T1, T2](val _1: T1, val _2: T2)

object TuplesMain extends {

    val list = List("a","b","c")

    val t2 = new Tuple3(1, "a", true)

    val t = new STuple(1, "a")
    t._1
    t._2
}