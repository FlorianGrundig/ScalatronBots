package de.fg.scala.bot

import bot1.bot.{MiniBot, MasterBot}

class ControlFunction {


  val masterBot = new MasterBot()
  val miniBot = new MiniBot()


  def respond(input: String): String = {
    val (opcode, paramMap) = CommandParser(input)
    if (opcode != "React") {
      return "Say(text='received unknown opcode: " + opcode + " ')"
    }


    val generation = paramMap("generation").toInt
    if (generation == 0) {
      masterBot.react(opcode,paramMap)
    } else {
      miniBot.react(opcode,paramMap)
    }
  }
}

object CommandParser {

  /** "Command(..)" => ("Command", Map( ("key" -> "value"), ("key" -> "value"), ..}) */
  def apply(command: String): (String, Map[String, String]) = {
    /** "key=value" => ("key","value") */
    def splitParameterIntoKeyValue(param: String): (String, String) = {
      val segments = param.split('=')
      (segments(0), if(segments.length>=2) segments(1) else "")
    }
    val segments = command.split('(')
    if( segments.length != 2 )
      throw new IllegalStateException("invalid command: " + command)
    val opcode = segments(0)
    val params = segments(1).dropRight(1).split(',')
    val keyValuePairs = params.map(splitParameterIntoKeyValue).toMap
    (opcode, keyValuePairs)
  }
}

