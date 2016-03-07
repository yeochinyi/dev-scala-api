package tutorial.java.programmers

import java.text.DateFormat.LONG
import java.text.DateFormat.getDateInstance
import java.util.Locale

object FrenchDate {
  def main(args: Array[String]) {
    //val now = new Date(0,0,0)
    val now = new java.util.Date()
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
  }
}
 