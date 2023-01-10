/**
 * @author Nadezhda Tsvetkova
 * @id 11942924
 */
package default

trait ShoppingCart {
  def delete(id: Int): Array[StoreItem]
  def search(name: String): Array[StoreItem]
  def sortByValueAsc(): Array[StoreItem]
  def sortByValueDesc(): Array[StoreItem]
  def store(item: StoreItem): Array[StoreItem]
  def sumUp(): Int
}