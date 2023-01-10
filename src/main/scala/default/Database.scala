/**
 * @author Nadezhda Tsvetkova
 * @id 11942924
 */
package default

class Database extends ShoppingCart {
  private var storedItems = Array[StoreItem]()

  override def delete(id: Int): Array[StoreItem] = {
    var item = storedItems.find(item => item.id == id)
    item match { //if found item -> delete it, if not print the error
      // it can be done also with if(item.isDefined) else, equivalent
      case Some(found) => found.logAction("deleted", found.name)
      case None => println(id.toString() + " not found")
    }
    storedItems = storedItems.filter(itemSt => itemSt.id != id)
    storedItems
  }

  override def search(name: String): Array[StoreItem] = { //search=filterByName

    var searchListOfItems = storedItems.filter(si => si.name.contains(name))
    if (searchListOfItems.isEmpty)
      println("name " + name + " not found")
    searchListOfItems.foreach(s => s.logAction("found", name))
    searchListOfItems
  }

  def sortByValueAsc(): Array[StoreItem] = {
    var sorted = storedItems.sortWith((s, t) => s.value < t.value)
    sorted
  }

  def sortByValueDesc(): Array[StoreItem] = {
    var sorted = storedItems.sortWith((s, t) => s.value > t.value)
    sorted
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    if (storedItems.exists(si => si.id == item.id))
      println("The Item is already in the list")
    else {
      storedItems = storedItems :+ item //append item to the array of stored items
      item.logAction("stored", item.name)
    }
    storedItems
  }

  def higherOrder(items: StoreItem, printFun: (String, String) => Unit): Unit = {
    printFun(items.name, items.value.toString)
  }

  def filterByName(name: String): Array[StoreItem] = {
    var filteredItems = storedItems.filter(item => item.name.contains(name))
    filteredItems.sortBy(item => item.value)
    filteredItems
  }

  override def sumUp(): Int = {
    storedItems.map(storedItems => storedItems.value).sum
  }
}
