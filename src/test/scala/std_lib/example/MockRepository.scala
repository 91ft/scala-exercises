package std_lib.example

import java.util.{Calendar, Date}

/**
  * Created by karellen on 2016. 8. 31..
  */

class MockPageRepository {

  def getMD(): Page = ??? //Page(100, 100, new Date())

  def getProducts(n : Int): List[Page] = ???
    //(10 to 10 + n).map(id => Page(id, id - 10, new Date())).toList
}

class MockISoolHttpClient {
  def getItems(ids : Seq[Int]): List[Item] = ???
    //ids.filter(id => id != 0).map(id => Item(id, if (id == 100) "MD" else s"상품${id}", s"이미지${id}")).toList
}
