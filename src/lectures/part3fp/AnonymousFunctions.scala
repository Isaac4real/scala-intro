package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler: (Int) => Int = (a: Int) => 2 * a // _ * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int =  (a: Int, b: Int) => a + b //_ + _

  // no params

  val something: () => Int = () => 3

  // careful
  println(something) // func itself
  println(something()) // call

  // curly braces in lambdas
  val str2Int = {(str: String) =>
    str.toInt
  }
  val str2Int_2: String => Int = {(str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  // 1. Rewrite funk with more syntactic sugar
  val funk2 = (a: Int) => (b: Int) => (a + 1) + b
  println(funk2(2)(2))
}
