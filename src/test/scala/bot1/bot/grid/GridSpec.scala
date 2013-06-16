package bot1.bot.grid

import org.scalatest.{FlatSpec, OneInstancePerTest, FunSpec}

class GridSpec extends FlatSpec {

  val gridWithLengthOf3 =
    "" +
      "WWW" +
      "W_W" +
      "WWW"
  val gridWithLengthOf4 =
    "" +
      "WWWW" +
      "W__W" +
      "W__W" +
      "WWWW"
  val gridWithLengthOf5 =
    "" +
      "WWWWW" +
      "W___W" +
      "W___W" +
      "W___W" +
      "WWWWW"
  val gridWithLengthOf15 =
    "" +
      "WWWWWWWWWWWWWWW" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "W___WW___WW___W" +
      "WWWWWWWWWWWWWWW"


  "A creatable Grid" should "have an odd-numbered length, because in the center is our MasterBot" in {
    Grid(gridWithLengthOf3)
    Grid(gridWithLengthOf5)
    Grid(gridWithLengthOf15)
  }

  "A Grid with an even-numbered length" should "not be creatable" in {
    intercept[IllegalArgumentException] {
      Grid(gridWithLengthOf4)
    }
  }

  "A creatable Grid" should "have a radius half the (length-1)" in {
    assert(1 === Grid(gridWithLengthOf3).Radius)
    assert(2 === Grid(gridWithLengthOf5).Radius)
    assert(7 === Grid(gridWithLengthOf15).Radius)
  }

  "isCoordinateValid" should "return true, if coordinate is within the radius (for all directions from the center)" in {
    val grid = Grid(gridWithLengthOf5)

    assert(true === grid.isCoordinateValid(Coordinate(0, 0)))
    assert(true === grid.isCoordinateValid(Coordinate(1, 0)))
    assert(true === grid.isCoordinateValid(Coordinate(2, 0)))
    assert(true === grid.isCoordinateValid(Coordinate(-1, 0)))
    assert(true === grid.isCoordinateValid(Coordinate(-2, 0)))
    assert(true === grid.isCoordinateValid(Coordinate(1, 1)))
    assert(true === grid.isCoordinateValid(Coordinate(2, 1)))
    assert(true === grid.isCoordinateValid(Coordinate(-1, 1)))
    assert(true === grid.isCoordinateValid(Coordinate(-2, 1)))
    assert(true === grid.isCoordinateValid(Coordinate(1, 2)))
    assert(true === grid.isCoordinateValid(Coordinate(2, 2)))
    assert(true === grid.isCoordinateValid(Coordinate(-1, 2)))
    assert(true === grid.isCoordinateValid(Coordinate(-2, 2)))
    assert(true === grid.isCoordinateValid(Coordinate(1, -1)))
    assert(true === grid.isCoordinateValid(Coordinate(2, -1)))
    assert(true === grid.isCoordinateValid(Coordinate(-1, -1)))
    assert(true === grid.isCoordinateValid(Coordinate(-2, -1)))
    assert(true === grid.isCoordinateValid(Coordinate(1, -2)))
    assert(true === grid.isCoordinateValid(Coordinate(2, -2)))
    assert(true === grid.isCoordinateValid(Coordinate(-1, -2)))
    assert(true === grid.isCoordinateValid(Coordinate(-2, -2)))
  }

  "isCoordinateValid" should "return false, if coordinate is not within the radius (for all directions from the center)" in {
    val grid = Grid(gridWithLengthOf5)

    assert(false === grid.isCoordinateValid(Coordinate(3, 0)))
    assert(false === grid.isCoordinateValid(Coordinate(0, 3)))
    assert(false === grid.isCoordinateValid(Coordinate(0, -3)))
    assert(false === grid.isCoordinateValid(Coordinate(3, -3)))
    assert(false === grid.isCoordinateValid(Coordinate(-3, 0)))
    assert(false === grid.isCoordinateValid(Coordinate(-3, -3)))
  }

  "getGridElement" should "return the expected GridElement for the given coordinate" in {
    val grid = Grid(
      "" +
        "W?_??" +
        "MmSs?" +
        "WW?WW" +
        "WWWWW" +
        "PpBb?")

    assert(GridElement.Wall === grid.getGridElement(Coordinate(-2,-2))) // left up
    assert(GridElement.Unknown === grid.getGridElement(Coordinate(-1,-2)))
    assert(GridElement.EmptyCell === grid.getGridElement(Coordinate(0,-2)))
    assert(GridElement.Unknown === grid.getGridElement(Coordinate(1,-2)))
    assert(GridElement.Unknown === grid.getGridElement(Coordinate(2,-2))) // right up

    assert(GridElement.Master === grid.getGridElement(Coordinate(-2,-1)))
    assert(GridElement.EnemyMaster === grid.getGridElement(Coordinate(-1,-1)))
    assert(GridElement.MiniBot === grid.getGridElement(Coordinate(0,-1)))
    assert(GridElement.EnemyMiniBot === grid.getGridElement(Coordinate(1,-1)))
    assert(GridElement.Unknown === grid.getGridElement(Coordinate(2,-1)))

    assert(GridElement.Wall === grid.getGridElement(Coordinate(-2,0)))
    assert(GridElement.Wall === grid.getGridElement(Coordinate(-1,0)))
    assert(GridElement.Unknown === grid.getGridElement(Coordinate(0,0))) // center
    assert(GridElement.Wall === grid.getGridElement(Coordinate(1,0)))
    assert(GridElement.Wall === grid.getGridElement(Coordinate(2,0)))

    assert(GridElement.Wall === grid.getGridElement(Coordinate(-2,1)))
    assert(GridElement.Wall === grid.getGridElement(Coordinate(-1,1)))
    assert(GridElement.Wall === grid.getGridElement(Coordinate(0,1)))
    assert(GridElement.Wall === grid.getGridElement(Coordinate(1,1)))
    assert(GridElement.Wall === grid.getGridElement(Coordinate(2,1)))

    assert(GridElement.Zugar === grid.getGridElement(Coordinate(-2,2))) // left down
    assert(GridElement.Toxifera === grid.getGridElement(Coordinate(-1,2)))
    assert(GridElement.Fluppet === grid.getGridElement(Coordinate(0,2)))
    assert(GridElement.Snorg === grid.getGridElement(Coordinate(1,2)))
    assert(GridElement.Unknown === grid.getGridElement(Coordinate(2,2))) // right down

  }


}
