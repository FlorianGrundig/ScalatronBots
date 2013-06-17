package bot1.bot.ai

import org.scalatest.FlatSpec
import bot1.bot.grid.{Coordinate, Grid}

class PoisSpec extends FlatSpec {

  val gridWithLengthOf5 =
    "" +
      "WWBWW" +
      "WbSpW" +
      "B?_mP" +
      "WbspW" +
      "WWPWW"

  "getPois" should "return coordinates with Fluppets or Zugars on it" in {
    val grid = Grid(gridWithLengthOf5)

    val pois = Pois(grid).getPois

    assert(List(Coordinate(0,-2),Coordinate(-2,0), Coordinate(2, 0),Coordinate(0, 2)) === pois)
  }

}
