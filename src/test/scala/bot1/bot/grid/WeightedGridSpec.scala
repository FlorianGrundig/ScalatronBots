package bot1.bot.grid

import org.scalatest.FlatSpec


class WeightedGridSpec extends FlatSpec {


  "getWeight" should "return 10000, if grid element at the given coordinate is a wall" in {
    val grid = Grid(
      "" +
        "WWWWW" +
        "W___W" +
        "W___W" +
        "W___W" +
        "WWWWW")

    val weightedGrid = WeightedGrid(grid)

    assert(10000 === weightedGrid.getWeight(Coordinate(2,2)))  // TODO access values from WeightedGrid directly
  }

  "getWeight" should "return originalGrid.Radius * 100, if grid element at the given coordinate is a enemy" in {
    val grid = Grid(
      "" +
        "WWWWW" +
        "Wp__W" +
        "W___W" +
        "W___W" +
        "WWWWW")

    val weightedGrid = WeightedGrid(grid)

    assert(4 === weightedGrid.getWeight(Coordinate(-1,-1)))  // TODO access values from WeightedGrid directly
  }

}
