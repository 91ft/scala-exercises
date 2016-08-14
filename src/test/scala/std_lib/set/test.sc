val list1 = List(1,1,2)
val list2 = List(1,1,2,3)

list2.contains(list1)

val set1 = Set(1,2)
val set2 = Set(1,2,3)

set2.subsets(2).toList