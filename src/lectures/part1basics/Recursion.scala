package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt={
      if (x == 1) accumulator
      else factorialHelper(x-1, x * accumulator)
    } // tail recursive -> use recursive calls as the LAST expression
    factorialHelper(n, 1)
  }

  @tailrec
  def concatenateTailRec(a: String, i: Int, accumulator: String): String = {
    if (i <= 0) accumulator
    else concatenateTailRec(a, i-1, a + accumulator)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t:Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, (n%t != 0) && isStillPrime)

    isPrimeTailRec(n/2, true)
  }

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int=
      if(i >= n) last
      else fibonacciTailRec(i+1, last + nextToLast, last)

    if(n <= 2) 1
    fibonacciTailRec(2, 1, 1)
  }
}
