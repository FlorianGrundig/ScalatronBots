package bot1.bot

import de.fg.scala.bot.XY
import util.Random

class MainBot {
  val rnd = new Random()

  def react(opcode: String, paramMap:  Map[String, String]): String = {
    if (paramMap("energy").toInt >= 100 && rnd.nextDouble() < 0.05) {
      val heading = XY.random(rnd)
      val headingStr = heading.x + ":" + heading.y // e.g. "-1:1"
      "Spawn(direction=" + headingStr + ",energy=100,heading=" + headingStr + ")"
    } else {
      val heading = XY.random(rnd)
      val headingStr = heading.x + ":" + heading.y
      "Move(direction=" + headingStr + ")"
    }
  }
}
