package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)
  // its the same output

  def aRecursiveFunc(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRecursiveFunc(aString, n -1)
  }
  // WHEN YOU NEED LOOPS, USE RECURSION

  def aFuncWithSideEffects(aString: String): Unit = println(aString)

  def aBigfunc(n: Int): Int ={
    def aSmallFunc(a: Int, b: Int): Int = a + b
    aSmallFunc(n, n+1)
  }

  def aGreetingFunc(name: String, age: Int): String = {
    "zup, i'm" + name + "and i'm" + age
  }

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }
  //NOTE: this way of recursion can result in a stackoverflow error
  // USE TAIL RECURSION FOR THIS

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else (n%t == 0) && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
}
