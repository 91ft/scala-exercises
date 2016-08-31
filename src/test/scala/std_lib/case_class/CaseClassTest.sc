class Person1(val id : Int, val name : String, val tel : String)
case class Person2(id : Int, name : String, tel : String)

val person1 : Person1 = new Person1(1, "박보검", "010")
val person2 : Person2 = Person2(2, "김수현", "012")

person1.toString
person2.toString