package std_lib.example

import java.util.Date

/**
  * Created by karellen on 2016. 8. 31..
  */

// id, itemId, releasedAt이 있는 Page
case class Page(a : Int, b: Int, c : Date)
// id, name, imageUrl이 있는 Item
case class Item(a : Int, str1 : String, str2 : String)

class MockPageService {

  val repository = new MockPageRepository
  val httpClient = new MockISoolHttpClient

  def getDeal() : List[Item] = ???
}
