package bot1.bot.grid

case class WeightedGrid(originalGrid: Grid) {
  val WEIGHT_WALL = 10000
  val WEIGHT_ENEMY = originalGrid.Radius * 2

  def isCoordinateValid(coordinate: Coordinate): Boolean = originalGrid.isCoordinateValid(coordinate)
  def getGridElement(coordinate: Coordinate): GridElement.Value = originalGrid.getGridElement(coordinate)
  def coordinatesIterator():Iterator[Coordinate] = originalGrid.coordinatesIterator()
  def getNeighbors(coordinate: Coordinate): List[Coordinate] = originalGrid.getNeighbors(coordinate)

  def getWeight(coordinate: Coordinate): Int = {
    val gridElement = getGridElement(coordinate)

    gridElement match {
      case GridElement.Wall => WEIGHT_WALL
      case GridElement.EnemyMaster | GridElement.EnemyMiniBot | GridElement.Snorg | GridElement.Toxifera => WEIGHT_ENEMY
      case _ => 1
   }

  }
}
