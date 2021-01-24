package lectures.part1basics

object Expressions extends App {

  // EVERYTHING in scala is an Expression!
  // side-effects are: println(), whiles, reassigning

  val x = 1 +2 //EXPRESSION
  println(x)
  println(2 + 3 * 4)
  // + - * / & | << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && !!

  var aVar = 2
  aVar += 2 // -= *= /= .... side effects
  println(aVar)

  // Instructions  VS Expressions
  // (DO - doing something, imperial progr.) VS (Values or Types)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3

  // while loop (avoid them!)
  var i = 0
  val aWhile:Unit = while (i < 10){
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN
  // whiles are used in imperative langs like python, java, C, ...
  // EVERYTHING in Scala is an expression

  val aWeirdVal: Unit = (aVar = 3) // Unit === Void in other langs
  println(aWeirdVal) // out: ()

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z < 2) "hello" else "goodbye"
  }


}
