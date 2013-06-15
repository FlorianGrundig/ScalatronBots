package bot1.bot

import de.fg.scala.bot.Coordinate

class MiniBot {
   def react(opcode: String, paramMap:  Map[String, String]): String = {
     val headingStr = paramMap("heading")
     val directions = headingStr.split(':').map(_.toInt) // e.g. "-1:1" => Array(-1,1)
     "Move(direction=" + directions(0) + ":" + directions(1) + ")"
   }
 }
