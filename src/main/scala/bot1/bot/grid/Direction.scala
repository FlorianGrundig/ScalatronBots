package bot1.bot.grid

import scala.util.Random

/**
 * A direction is vector with the initial point Coordinate(0,0) and terminal point given by the direction coordinate.
 */
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
