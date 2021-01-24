package lectures.part1basics

object ValuesvariablesTypes extends App {

  val x: Int = 42
  println(x)

  // vals are imutable and vars are not
  // compiler infers schema
  // not assigning types to a var causes a side effect
  // types avail: Int, Boolean, Char, String, Short, Long, Float, Double

  var aVariable: Int = 2

  var aSideEffect = 5
}
