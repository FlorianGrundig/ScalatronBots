import de.fg.scala.bot.CommandResponder

class ControlFunctionFactory {
  def create = new CommandResponder().respond _
}
