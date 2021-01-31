package lectures.part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, (Int) => Boolean) => Int) => (Int => Int) = null
  // higher order function

  // map, flatMap, filter in MyList

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(plusOne, 10, 1)

  // ntb(f, n) = x => f(f(...f(x)))
  // increment10Times = ntb(plusOne, 10) = x => plusOne(...plusOne(x))
  // val y = increment10Times(1)
  def nTimesBetter(f: Int => Int, n: Int): Int => Int =
    if (n <= 0) (x:Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val increment10Times = nTimesBetter(plusOne, 10)
  val y = increment10Times(1)

  // curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameters list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
    1.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
        fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

    2.  compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))
   */

  // 1.
  def toCurry(f: (Int, Int) => Int) : (Int => Int => Int) = {
    x => y => f(x, y)
  }
  def fromCurrie(f: Int => Int => Int): (Int, Int) => Int = {
    (x: Int, y: Int) => f(x)(y)
  }

  // 2.
  def compose[A, B, C](f: A => B, g: C => A): C => B = {
    x => f(g(x))
  }
  def andThen[A, B, C](f: A => C, g: C => B): A => B = {
    x => g(f(x))
  }

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4 = superAdder2(4)
  println(add4(17))

  def simpleAdder: ((Int, Int) => Int) = fromCurrie(superAdder)
  println(simpleAdder(4,17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))


}