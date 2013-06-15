package bot1.bot


object GridElement extends Enumeration {
  type GridElement = Value
  val Unknown, Wall, EmptyCell, Master, EnemyMaster, MiniBot, EnemyMiniBot, Zugar, Toxifera, Fluppet, Snorg = Value

  def getElement(text: Char): GridElement = text match {
    case '?' => Unknown
    case 'W' => Wall
    case '_' => EmptyCell
    case 'M' => Master
    case 'm' => EnemyMaster
    case 'S' => MiniBot
    case 's' => EnemyMiniBot
    case 'P' => Zugar
    case 'p' => Toxifera
    case 'B' => Fluppet
    case 'b' => Snorg
  }

}