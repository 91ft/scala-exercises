package std_lib.higher_order_functions

/**
 * Created by karellen on 2016. 8. 2..
 */
object HigherOrderFunctions extends App {

  def defFunc = {
    val r = util.Random.nextInt
    () => r
  }

  val valFunc = {
    val r = util.Random.nextInt
    () => r
  }

  println(defFunc())
  println(defFunc())

  println(valFunc())
  println(valFunc())
}
