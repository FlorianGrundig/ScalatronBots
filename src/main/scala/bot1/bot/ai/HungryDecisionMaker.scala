package bot1.bot.ai

import bot1.bot.grid._
import bot1.bot.grid.Coordinate
import bot1.bot.grid.Grid
import bot1.bot.ai.path.AStar
import scala.collection.parallel.mutable
import scala.collection.mutable.HashMap
import scala.util.Random
import scala.collection.immutable.TreeMap
import bot1.bot.Status
import bot1.bot

/**
 * Focusing on getting more and more energy...
 *
 * @param grid
 */
case class HungryDecisionMaker(grid: Grid) {

  val weightedGrid = WeightedGrid(grid)

  def getNextHeading(): Coordinate = {
    // get pois

    var pois = Pois(grid).getPois

    if (pois.size == 0) {
      pois += selectFreeField(Status.currentHeading)
    }

    val m = new HashMap[Int, List[Coordinate]]()
    for (poi <- pois) {
      val astar  = new AStar(weightedGrid, poi)
      val path = astar.getShortestPath()

      if (path != null)
        m.put(path.length, path)

    }

    val t = TreeMap(m.toSeq: _*)
    val newDirection = t.head._2(1)
    return newDirection


  }

  def selectFreeField(direction: Coordinate): Coordinate = {
    var currentDirection = direction
    var newPoi = Coordinate(0, 0)
    var counter = 0

    if (currentDirection == Coordinate(0, 0)) {
      currentDirection = Coordinate(1, 1)
    }
    while (newPoi == Coordinate(0, 0)) {
      while (grid.isCoordinateValid(newPoi + currentDirection) && grid.getGridElement(newPoi + currentDirection) != GridElement.EmptyCell) {
        newPoi = newPoi + currentDirection
      }

      if (grid.isCoordinateValid(newPoi + currentDirection)) {
        newPoi = newPoi + currentDirection
      } else {
        newPoi = Coordinate(0,0)
      }

      counter += 1

      if (counter % 4 == 0) {
        currentDirection = Coordinate(currentDirection.x * -1, currentDirection.y)
      } else
      if (counter % 4 == 1) {
        currentDirection = Coordinate(currentDirection.x, currentDirection.y * -1)
      } else
      if (counter % 4 == 2) {
        currentDirection = Coordinate(currentDirection.x * -1, currentDirection.y * -1)
      } else
      if (counter % 4 == 3) {
        currentDirection = Coordinate(1, 1)
      }


    }
    newPoi
  }


}
