package bot1.bot

import bot1.bot.grid.Coordinate

class MiniBot {
   def react(opcode: String, paramMap:  Map[String, String]): String = {
     val headingStr = paramMap("heading")
     val directions = headingStr.split(':').map(_.toInt) // e.g. "-1:1" => Array(-1,1)
     "Move(direction=" + directions(0) + ":" + directions(1) + ")"
   }
 }
