package lectures.part3fp

import scala.util.Random

object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // WORK with unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(null) // WRONG
  var result = Option(unsafeMethod()) // some or none
  println(result)

  // chained methods
  def backupMethod(): String = "a valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("a valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE do not use

  // map, flatmap, filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x => x>10))
  println(myFirstOption.flatMap(x => Option(x*10)))

  // for comprehensions

  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so print the connection method
  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))

  val connectionStatus = connection.map(c => c.connect)

  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p))
        .map(c => c.connect))
    .foreach(println)

  // for comprehension
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield  connection.connect

  forConnectionStatus.foreach(println)

}
