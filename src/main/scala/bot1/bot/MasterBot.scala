package bot1.bot

import util.Random
import bot1.bot.grid.Grid
import bot1.bot.ai.SimpleDecisionMaker

class MasterBot {
  val rnd = new Random()

  def react(opcode: String, paramMap:  Map[String, String]): String = {
    val grid = Grid(paramMap("view"))
    val simpleDecisionMaker = SimpleDecisionMaker(grid)
    val nextHeading = simpleDecisionMaker.getNextHeading()

    val headingStr = nextHeading.x + ":" + nextHeading.y
    "Move(direction=" + headingStr + ")"
  }




}
