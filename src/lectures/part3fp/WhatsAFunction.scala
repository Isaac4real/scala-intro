package lectures.part3fp

object WhatsAFunction extends App{
  // DREAM: use functions as first class elements
  // Problem: OOP

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = 2 * element
  }
  println(doubler(2))

  // function types = Function1[A, B]
  val StringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(StringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int,Int, Int] {
    override def apply(a:Int, b:Int): Int = a + b
  }
  // adder with syntactic sugar:
  val adder2: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1.  a function which takes 2 strings and concatenates them
    2.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  // 1.
  val concatenate: (String, String) => String =
    (string1: String, string2: String) => string1 + string2

  // 2.
  val funk: Int => Int => Int = (a: Int) => (b: Int) => (a +1) + b
  println(funk(1)(2)) // curried function

  // the above two funcs are actually anonymous/lambdas funcs

}

trait MyFunction[A, B]{
  def apply(element: A): B
}
