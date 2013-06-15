package bot1.bot

import de.fg.scala.bot.Coordinate
import scala.util.Random


object Direction {
  def random(rnd: Random) = Coordinate(rnd.nextInt(3)-1, rnd.nextInt(3)-1)

  val Right      = Coordinate( 1,  0)
  val RightUp    = Coordinate( 1, -1)
  val Up         = Coordinate( 0, -1)
  val UpLeft     = Coordinate(-1, -1)
  val Left       = Coordinate(-1,  0)
  val LeftDown   = Coordinate(-1,  1)
  val Down       = Coordinate( 0,  1)
  val DownRight  = Coordinate( 1,  1)
}
