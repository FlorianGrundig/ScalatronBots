package bot1.bot

import util.Random

class MasterBot {
  val rnd = new Random()

  def react(opcode: String, paramMap:  Map[String, String]): String = {
    var grid = Grid(paramMap("view"))
    var simpleDecisionMaker = SimpleDecisionMaker(grid)
    val nextHeading = simpleDecisionMaker.getNextHeading()

    val headingStr = nextHeading.x + ":" + nextHeading.y
    "Move(direction=" + headingStr + ")"

   /* if (paramMap("energy").toInt >= 100 && rnd.nextDouble() < 0.05) {
      val heading = Coordinate.random(rnd)
      val headingStr = heading.x + ":" + heading.y // e.g. "-1:1"
      "Spawn(direction=" + headingStr + ",energy=100,heading=" + headingStr + ")"
    } else {
      val heading = Coordinate.random(rnd)
      val headingStr = heading.x + ":" + heading.y
      "Move(direction=" + headingStr + ")|Say(text='Hallo Bot   35')"
    }*/
  }




}
