package bot1.bot.ai

import bot1.bot.grid.{GridElement, Direction, Grid, Coordinate}
import bot1.bot.Status


case class SimpleDecisionMaker(grid: Grid) {


  def getNextHeading(): Coordinate = {
    val availableDirections = getAvailableDirections()

    var nextHeading = availableDirections(0)
    if (!isThereSomethingEvil(Status.currentHeading) && Status.currentHeading != Coordinate(0,0)){
      nextHeading = Status.currentHeading
    }


    var numberOfGoodThingsInHeading = 0
    var numberOfEvilThingsInHeading = 0

    for (direction <- availableDirections) {
      var coordinate = Coordinate(0, 0)
      var distanceFromMaster = 0
      var numberOfGoodThings = 0
      var numberOfEvilThings = 0

      while (grid.isCoordinateValid(coordinate.+(direction))) {
        coordinate = coordinate.+(direction)
        if (isThereSomethingGood(coordinate)) {
          numberOfGoodThings += (grid.Radius - distanceFromMaster) ^ 2
        } else
        if (isThereSomethingEvil(coordinate)) {
          numberOfEvilThings += (grid.Radius - distanceFromMaster) ^ 2
        }
        distanceFromMaster += 1
      }


      if (numberOfGoodThings > numberOfGoodThingsInHeading && numberOfEvilThings <= numberOfEvilThingsInHeading) {
        nextHeading = direction
        numberOfEvilThingsInHeading = numberOfEvilThings
        numberOfGoodThingsInHeading = numberOfGoodThingsInHeading
      } else
      if (numberOfGoodThings > 0 && numberOfGoodThings <= numberOfGoodThingsInHeading && numberOfEvilThings <= numberOfEvilThingsInHeading / 2) {
        nextHeading = direction
        numberOfEvilThingsInHeading = numberOfEvilThings
        numberOfGoodThingsInHeading = numberOfGoodThingsInHeading
      }

    }

    nextHeading
  }


  private def getAvailableDirections(): List[Coordinate] = {
    val availableDirections = List(
      Direction.Down,
      Direction.DownRight,
      Direction.Left,
      Direction.LeftDown,
      Direction.Right,
      Direction.RightUp,
      Direction.Up,
      Direction.UpLeft)


    availableDirections.filter((direction: Coordinate) =>
      !isThereSomethingEvil(direction)
    )

  }


  private def isThereSomethingGood(direction: Coordinate): Boolean = {
    GridElement.Fluppet == grid.getGridElement(direction) ||
      GridElement.Zugar == grid.getGridElement(direction)
  }

  private def isThereSomethingEvil(direction: Coordinate): Boolean = {
    GridElement.Wall == grid.getGridElement(direction) ||
      GridElement.EnemyMaster == grid.getGridElement(direction) ||
      GridElement.EnemyMiniBot == grid.getGridElement(direction) ||
      GridElement.Snorg == grid.getGridElement(direction) ||
      GridElement.Toxifera == grid.getGridElement(direction)
  }

}
