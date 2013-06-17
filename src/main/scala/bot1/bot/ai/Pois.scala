package bot1.bot.ai

import bot1.bot.grid.{GridElement, Coordinate, Grid}
import scala.collection.mutable.ListBuffer


case class Pois(grid: Grid) {

  def getPois :ListBuffer[Coordinate] = {
    val buffer = new ListBuffer[Coordinate]()
    val it = grid.coordinatesIterator()
    while (it.hasNext){
      val coordinate = it.next()
       grid.getGridElement(coordinate) match {
         case GridElement.Fluppet | GridElement.Zugar => buffer += coordinate
         case _ => // nop
       }
    }
    buffer
  }

}
