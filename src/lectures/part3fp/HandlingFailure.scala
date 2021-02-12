package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{

  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("super failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("no string for you")

  // Try objects via the apply method
  val pottentialFailure = Try(unsafeMethod())
  println(pottentialFailure)


  // syntax sugar
  val anotherPotencialFailure = Try {
    // code
  }

  // urilities
  println(pottentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "a valid request"

  val fallbackTry = Try(pottentialFailure) orElse Try(backupMethod())

  // IF you design the API
  def aBetterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def aBetterBackupMethod(): Try[String] = Success("a valid result")
  val aBetterFallBack = aBetterUnsafeMethod() orElse aBetterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_*2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  // Exercise

  val host = "loalhost"
  val port = "8080"
  def RenderHTML(page: String): Unit = println(page)

  class Conncection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }
    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Conncection = {
      if(random.nextBoolean()) new Conncection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Conncection] = Try(getConnection(host, port))

  }

  // if you get the html page from the connection, print it to the console i.e. call renderHTML
  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(RenderHTML)

  // shorhand version

  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(RenderHTML)

  // for comprehension
  for{
    conncetion <- HttpService.getSafeConnection(host, port)
    page <- conncetion.getSafe("/home")
  } RenderHTML(page)




}
