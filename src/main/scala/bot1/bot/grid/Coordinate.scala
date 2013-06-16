package bot1.bot.grid

case class Coordinate(x: Int, y: Int) {

  def copy = Coordinate(x,y)

  def +(pos: Coordinate) = Coordinate(x+pos.x, y+pos.y)
}



