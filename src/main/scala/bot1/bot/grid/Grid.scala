package bot1.bot.grid

import scala.collection.mutable.ListBuffer


case class Grid(view: String) {
  val Radius = getRadius(view)
  val currentGrid = convert(view)
  private val masterBotCoordinate = Coordinate(Radius, Radius)

  def isCoordinateValid(coordinate: Coordinate): Boolean = {
    scala.math.abs(coordinate.x) <= Radius &&
      scala.math.abs(coordinate.y) <= Radius
  }

  def coordinatesIterator(): Iterator[Coordinate] = {
    new Iterator[Coordinate] {
      private var index = 0

      def hasNext: Boolean = index < math.pow(2 * Radius + 1, 2)

      def next: Coordinate = {
        val currentRow = index / (2 * Radius + 1)
        val currentCol = index % (2 * Radius + 1)
        index += 1
        Coordinate(-1 * Radius + currentCol, -1 * Radius + currentRow)
      }
    }
  }


  def getGridElement(coordinate: Coordinate): GridElement.Value = {
    val newCoordinate = masterBotCoordinate + coordinate
    val gridElementAsString = currentGrid(newCoordinate.y)(newCoordinate.x)
    GridElement.getElement(gridElementAsString)
  }

  def getNeighbors(coordinate: Coordinate): List[Coordinate] = {
    val list = new ListBuffer[Coordinate]()
    list += Coordinate(coordinate.x - 1, coordinate.y)
    list += Coordinate(coordinate.x + 1, coordinate.y)
    list += Coordinate(coordinate.x - 1, coordinate.y - 1)
    list += Coordinate(coordinate.x, coordinate.y - 1)
    list += Coordinate(coordinate.x + 1, coordinate.y - 1)
    list += Coordinate(coordinate.x - 1, coordinate.y + 1)
    list += Coordinate(coordinate.x, coordinate.y + 1)
    list += Coordinate(coordinate.x + 1, coordinate.y + 1)
    list.filter(coordinate => isCoordinateValid(coordinate)).toList
  }

  private def getRadius(view: String): Int = {
    val length = scala.math.sqrt(view.length.toDouble).toInt
    if (isEven(length)) {
      throw new IllegalArgumentException("grid length must be odd-numbered")
    }
    length / 2
  }

  private def isEven(n: Int): Boolean = {
    (n / 2) * 2 == n
  }

  private def convert(view: String): Array[Array[Char]] = {
    val length = 2 * Radius + 1
    val grid = Array.ofDim[Char](length, length)

    for (y <- 0 until length) {
      for (x <- 0 until length) {
        grid(y)(x) = view.charAt(y * length + x)
      }
    }
    grid
  }

}
