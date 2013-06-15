package bot1.bot

import de.fg.scala.bot.Coordinate

case class Grid(view: String) {
  val Radius = getRadius(view)
  val currentGrid = convert(view)
  val masterBotCoordinate = Coordinate(Radius, Radius)

  def isCoordinateValid(coordinate: Coordinate): Boolean = {
    scala.math.abs(coordinate.x) <=  Radius  &&
    scala.math.abs(coordinate.y) <=  Radius
  }


  def getGridElement(coordinate: Coordinate): GridElement.Value = {
    val newCoordinate = masterBotCoordinate.+(coordinate)
    val gridElementAsString = currentGrid(newCoordinate.y)(newCoordinate.x)
    GridElement.getElement(gridElementAsString)
  }

  private def getRadius(view: String): Int = scala.math.sqrt(view.length.toDouble).toInt / 2

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
