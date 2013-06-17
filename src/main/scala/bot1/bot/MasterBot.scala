package bot1.bot

import util.Random
import bot1.bot.grid.Grid
import bot1.bot.ai.HungryDecisionMaker

class MasterBot {
  val rnd = new Random()

  def react(opcode: String, paramMap: Map[String, String]): String = {
    val grid = Grid(paramMap("view"))
    val decisionMaker = HungryDecisionMaker(grid)

    try {
      val nextHeading = decisionMaker.getNextHeading()
      Status.currentHeading = nextHeading

      val headingStr = nextHeading.x + ":" + nextHeading.y
      "Move(direction=" + headingStr + ")"
    } catch {
      case e: Exception => {
        println (e.toString)
        "Say(text=\"Error: " + e.toString + "\")"
      }
    }
  }


}
