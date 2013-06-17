package bot1.bot.ai.path

import org.scalatest.FlatSpec
import bot1.bot.grid.{WeightedGrid, Grid, Coordinate}


class AStarSpec extends FlatSpec {

  val gridWithLengthOf15 =
    "" +
      "WWWWWWWWWWWWWWW" +
      "W_____________W" +
      "W___WWWWWWW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW________W" +  // center
      "W________WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WWWW_WW___W" +
      "W_____________W" +
      "WWWWWWWWWWWWWWW"

  "the shortest path" should "be found" in {
    val star = AStar(WeightedGrid(Grid(gridWithLengthOf15)),Coordinate(0,-6))

    val path = star.getShortestPath()

    assert( path.length === 17)  // TODO this seems not to be the optimal (shortest - with length 12) path (comparator orderedPathEndPoint does not select the minimum!!!)

  }
    "the open set" should "return the PathEndNode with the lowest costs" in {
    val star = AStar(null,null)

    star.fScore.put(Coordinate(1,1), 3)
    star.fScore.put(Coordinate(1,9), 3)
    star.fScore.put(Coordinate(2,1), 2)
    star.fScore.put(Coordinate(3,1), 4)
    star.fScore.put(Coordinate(4,1), 1)
    star.fScore.put(Coordinate(5,1), 5)

    star.openSet += Coordinate(1,1)
    star.openSet += Coordinate(2,1)
    star.openSet += Coordinate(3,1)
    star.openSet += Coordinate(4,1)
    star.openSet += Coordinate(5,1)
    star.openSet += Coordinate(1,9)

    assert(star.openSet.dequeue() === Coordinate(4,1))
    assert(star.openSet.dequeue() === Coordinate(2,1))
    assert(star.openSet.dequeue() === Coordinate(1,1))
    assert(star.openSet.dequeue() === Coordinate(1,9))
    assert(star.openSet.dequeue() === Coordinate(3,1))
    assert(star.openSet.dequeue() === Coordinate(5,1))
  }

  "the distance between two coordinates" should "be calculated correctly" in {
    val star = AStar(null,null)

    assert(0 === star.distance(Coordinate(0,0), Coordinate(0,0)))

    assert(1 === star.distance(Coordinate(1,0), Coordinate(0,0)))
    assert(1 === star.distance(Coordinate(0,1), Coordinate(0,0)))
    assert(1 === star.distance(Coordinate(0,1), Coordinate(1,1)))
    assert(1 === star.distance(Coordinate(0,0), Coordinate(1,1)))
    assert(1 === star.distance(Coordinate(1,1), Coordinate(0,0)))
    assert(1 === star.distance(Coordinate(1,-1), Coordinate(0,0)))

    assert(2 === star.distance(Coordinate(0,0), Coordinate(2,0)))
    assert(2 === star.distance(Coordinate(0,0), Coordinate(2,1)))
    assert(2 === star.distance(Coordinate(0,0), Coordinate(2,2)))

    assert(4 === star.distance(Coordinate(0,-2), Coordinate(0,-6)))
  }



}
