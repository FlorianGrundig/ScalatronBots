package de.fg.scala.bot

import util.Random


case class Coordinate(x: Int, y: Int) {
  def copy = Coordinate(x,y)
  def isNonZero = x!=0 || y!=0
  def isZero = x==0 && y==0
  def isNonNegative = x>=0 && y>=0

  def updateX(newX: Int) = Coordinate(newX, y)
  def updateY(newY: Int) = Coordinate(x, newY)

  def addToX(dx: Int) = Coordinate(x+dx, y)
  def addToY(dy: Int) = Coordinate(x, y+dy)

  def +(pos: Coordinate) = Coordinate(x+pos.x, y+pos.y)
  def -(pos: Coordinate) = Coordinate(x-pos.x, y-pos.y)
  def *(factor: Double) = Coordinate((x*factor).intValue, (y*factor).intValue)

  def distanceTo(pos: Coordinate) : Double = (this-pos).length
  def length : Double = math.sqrt(x*x + y*y)

  def signum = Coordinate(x.signum, y.signum)

  def negate = Coordinate(-x, -y)
  def negateX = Coordinate(-x, y)
  def negateY = Coordinate(x, -y)
  def isSame(other:Coordinate):Boolean = other.x == x && other.y == y
}

@deprecated
object Coordinate {
  def random(rnd: Random) = Coordinate(rnd.nextInt(3)-1, rnd.nextInt(3)-1)
  val Zero = Coordinate(0,0)
  val One =  Coordinate(1,1)

  val Right      = Coordinate( 1,  0)
  val RightUp    = Coordinate( 1, -1)
  val Up         = Coordinate( 0, -1)
  val UpLeft     = Coordinate(-1, -1)
  val Left       = Coordinate(-1,  0)
  val LeftDown   = Coordinate(-1,  1)
  val Down       = Coordinate( 0,  1)
  val DownRight  = Coordinate( 1,  1)
}


