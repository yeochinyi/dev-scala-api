

package tutorial.scala

import scala.util.control.Breaks

object TestScala extends App {
  type R = Double
  println((1 to 5).map(_ * 2))

  println((1 to 5).reduceLeft(_ + _))

  (1 to 5).map { x => val y = x * 2; println(y); y }

  println((1 to 5) filter { _ % 2 == 0 } map { _ * 2 })

  def compose(g: R => R, h: R => R) = (x: R) => g(h(x))
  val f = compose({ _ * 2 }, { _ - 1 })
  println(f(10))

  val zscore = (mean: R, sd: R) => (x: R) => (x - mean) / sd

  //def zscore(mean:R, sd:R) = (x:R) => (x-mean)/sd

  //def zscore(mean:R, sd:R)(x:R) = (x-mean)/sd

  val normer = zscore(7, 0.4)
  println(normer(5))

  def mapmake[T](g: T => T)(seq: List[T]) = seq.map(g)

  def myMap(x: R) = x * 2
  println(mapmake(myMap)(List(1, 2, 3)))

  def sum(args: Int*) = args.reduceLeft(_ + _)
  println(sum(1, 2, 3, 4))

  val xs = List(1, 2, 3)
  import scala.util.control.Breaks._
  breakable {
    for (x <- xs) {
      //if (Math.random < 0.1) break
      if (x > 2) break
      println(x)
    }
  }

  for (x <- xs if x % 2 == 0) yield x * 10

  //It is applied in combination with for and writes a new element into the resulting sequence.
  val res = for (a <- xs) yield a
  println("Arguments: " + res.toString)

  xs.filter(_ % 2 == 0).map(_ * 10)

  val ys = List(1, 2, 3)
  val zippy = for ((x, y) <- xs zip ys) yield x * y
  println(zippy)

  (xs zip ys) map { case (x, y) => x * y }

  for (x <- xs; y <- ys) {
    println("%d/%d = %d".format(x, y, x * y))
  }

  val flatMappy = xs flatMap { x => ys map { y => x * y } }
  println(flatMappy)

  //println(xs map(2*))
  //println(xs flatmap {_*2 })

  println((xs zip ys) map { case (x, y) => x * y })

  val v42 = 42
  Some(3) match {
    //is interpreted as a name matching any Int value, and is printed
    case Some(v42) => println("42")
    case _         => println("Not 42")
  }

  Some(3) match {
    //with backticks is interpreted as the existing val v42, and is printed.
    case Some(`v42`) => println("42")
    case _           => println("Not 42")
  }

  val UppercaseVal = 42
  Some(3) match {
    //UppercaseVal is treated as an existing val, 
    //rather than a new pattern variable, 
    //because it starts with an uppercase letter.
    //Thus, the value contained within UppercaseVal is checked against 3, and 42 is printed.
    case Some(UppercaseVal) => println("42")
    case _                  => println("Not 42")
  }
}