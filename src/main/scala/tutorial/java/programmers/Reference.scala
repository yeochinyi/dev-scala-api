package tutorial.java.programmers

class Reference[T] {
  /*
   *  _, which represents a default value. 
   *  This default value is 0 for numeric, 
   *  false for the Boolean type, 
   *  () for the Unit type and 
   *  null for all object types 
		*/
  private var contents: T = _
  def set(value: T) { contents = value }
  def get: T = contents
}

object IntegerReference {
  def main(args: Array[String]) {
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))
  }
}