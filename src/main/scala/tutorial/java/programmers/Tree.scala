package tutorial.java.programmers


/*
• the new keyword is not mandatory
• getter functions are automatically defined for the constructor parameters (i.e c.v),
• default definitions for methods equals and hashCode are provided, 
• a default definition for method toString is provided
• pattern matching
*/

abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree

object TestTree {

  //aim of the environment is to give values to variables
  //type Environment can be used as an alias of the type of functions from String to Int.
  type Environment = String => Int

  //why we did not define eval as a method of class Tree and its subclasses.
  //it is easy to add a new kind of node as this can be done just by defining the sub-class
  //adding a new operation to manipulate the tree is tedious,
  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }

  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if (v == n) => Const(1)
    case _ => Const(0)
  }

  def main(args: Array[String]) {
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = { case "x" => 5 case "y" => 7 }
    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: " + eval(exp, env))
    println("Derivative relative to x:\n " + derive(exp, "x"))
    println("Derivative relative to y:\n " + derive(exp, "y"))
  }

}

