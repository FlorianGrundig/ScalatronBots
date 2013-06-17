package bot1.bot.ai.path

import bot1.bot.grid.{WeightedGrid, Grid, Coordinate}
import scala.collection.mutable.ListBuffer
import scala.collection.mutable

case class AStar(grid: WeightedGrid, destination: Coordinate) {
  val closedSet = new mutable.HashSet[Coordinate]() // The set of node coordinates already evaluated.
  val openSet = new mutable.PriorityQueue[Coordinate]() // The set of tentative nodes to be evaluated, initially containing the start node
  val cameFrom = new mutable.HashMap[Coordinate, Coordinate]() // The map of navigated nodes.
  val gScore = new mutable.HashMap[Coordinate, Long]()  // Cost from start along best known path.
  val fScore = new mutable.HashMap[Coordinate, Long]()

  def distance(coordinate: Coordinate, other: Coordinate): Int = {
    math.sqrt(math.pow(coordinate.x - other.x, 2) + math.pow(coordinate.y - other.y, 2)).floor.toInt
  }

  // Comparator
  implicit def orderedPathEndPoint(f: Coordinate): Ordered[Coordinate] = new Ordered[Coordinate] {
    def compare(other: Coordinate) = -1 * fScore.apply(f).compare(fScore.apply(other))
  }

  def getShortestPath(): List[Coordinate] = {
    // start node
    gScore.put(Coordinate(0,0),0)
    fScore.put(Coordinate(0,0), distance(Coordinate(0,0), destination))
    openSet.enqueue(Coordinate(0,0))

    while (openSet.size > 0){
      val current = openSet.dequeue()

      if (current == destination){
        return reconstruct_path(current).toList
      }

      closedSet.add(current)
      for (neighbor <- grid.getNeighbors(current)) {
        val tentative_g_score = gScore.apply(current) + grid.getWeight(neighbor)

        if (!closedSet.contains(neighbor) ||  tentative_g_score < gScore.apply(neighbor)){

          gScore.put(neighbor,tentative_g_score)
          fScore.put(neighbor, tentative_g_score + distance(neighbor, destination))
          cameFrom.put(neighbor, current)

          if (!openSet.toList.contains(neighbor)){
            openSet.enqueue(neighbor)
          }
        }
      }
    }
    null
  }



  def reconstruct_path(current_node: Coordinate):ListBuffer[Coordinate] ={
    if (cameFrom.contains(current_node)) {
      val buffer = reconstruct_path(cameFrom.apply(current_node))
      buffer += current_node
    } else {
      val buffer = new ListBuffer[Coordinate]()
      buffer += current_node
    }
  }

}

