/**
 * @author Nadezhda Tsvetkova
 * @id 11942924
 */
package default

trait Logger {
  def logAction(actionName: String, name: String): Unit = {
    println(s"$name $actionName");
  }
}
