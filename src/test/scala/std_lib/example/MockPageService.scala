package std_lib.example

import java.util.Date

/**
  * Created by karellen on 2016. 8. 31..
  */

// id, itemId, releasedAt이 있는 Page
class Page
// id, name, imageUrl이 있는 Item
class Item

class MockPageService {

  val repository = new MockPageRepository
  val httpClient = new MockISoolHttpClient

  def getDeal() : List[Item] = ???
}
