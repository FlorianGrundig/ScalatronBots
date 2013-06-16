package bot1.bot.grid

import org.scalatest.FunSuite


class CoordinateSpec extends FunSuite{


  test("copy should create new coordinate with same x and y values") {
    val original = Coordinate(2,3)

    val copy = original.copy

    assert(!(original eq copy)) // eq means same object instances
    assert(original === copy)
  }

  test("+ method should add the x-coordinate and y-coordinate with returning a new instance") {
    val original = Coordinate(2,3)

    val newCoordinate = original.+(Coordinate(3,4))

    assert(!(original eq newCoordinate)) // eq means same object instances
    assert(original != newCoordinate)
    assert(newCoordinate.x === 5)
    assert(newCoordinate.y === 7)
  }

  test("+ operation should add the x-coordinate and y-coordinate with returning a new instance") {
    val original = Coordinate(2,3)

    val newCoordinate = original + Coordinate(3,4)

    assert(!(original eq newCoordinate)) // eq means same object instances
    assert(original != newCoordinate)
    assert(newCoordinate.x === 5)
    assert(newCoordinate.y === 7)
  }

}
