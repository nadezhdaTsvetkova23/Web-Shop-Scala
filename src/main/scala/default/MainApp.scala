/**
 * @author Nadezhda Tsvetkova
 * @id 11942924
 */
package default

object MainApp  {
  def main(args: Array[String]): Unit = {
    val db = new Database()

    val bufferedSource = io.Source.fromFile("./data.csv")
    var count = 0
    for(line <- bufferedSource.getLines()){
      val cols = line.split(",").map(_.trim)
      if(count > 0){
        db.store(new StoreItem(cols(0).toInt, cols(1), cols(2).toInt))
      }
      count += 1
    }
    bufferedSource.close

    println("--- SUM UP ---")
    println(db.sumUp())

    println("--- FILTERED BY ASUS ---")
    val filteredAsus = db.filterByName("ASUS")
    filteredAsus.foreach(item => println(item.name))
    println(filteredAsus.size)
    println("--- FILTERED BY Lenovo ---")
    val filteredLenovo = db.filterByName("Lenovo")
    filteredLenovo.foreach(item => println(item.name))
    println(filteredLenovo.size)
    println("--- FILTERED BY HP ---")
    val filteredHP = db.filterByName("HP")
    filteredHP.foreach(item => println(item.name))
    println(filteredHP.size)
    println("--- SORTED ITEMS ---")
    val sortedItems = db.sortByValueDesc()
    sortedItems.foreach(item => println(item.name + " " + item.value))

  }
}