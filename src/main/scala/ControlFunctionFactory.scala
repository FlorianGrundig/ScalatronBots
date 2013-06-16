import de.fg.scala.bot.ControlFunction

class ControlFunctionFactory {
  def create = new ControlFunction().respond _
}
