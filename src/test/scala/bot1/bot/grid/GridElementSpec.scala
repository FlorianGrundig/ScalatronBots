package bot1.bot.grid

import org.scalatest.{FlatSpec, FunSuite}

class GridElementSpec extends FlatSpec {


  "getElement" should "return the expected enum value 'Unknown' for the given input char '?'" in {
    expectResult(GridElement.Unknown) {
      GridElement.getElement('?')
    }
  }

  "getElement" should "return the expected enum value 'Wall' for the given input char 'W'" in {
    expectResult(GridElement.Wall) {
      GridElement.getElement('W')
    }
  }

  "getElement" should "return the expected enum value 'EmptyCell' for the given input char '_'" in {
    expectResult(GridElement.EmptyCell) {
      GridElement.getElement('_')
    }
  }

  "getElement" should "return the expected enum value 'Master' for the given input char 'M'" in {
    expectResult(GridElement.Master) {
      GridElement.getElement('M')
    }
  }

  "getElement" should "return the expected enum value 'EnemyMaster' for the given input char 'm'" in {
    expectResult(GridElement.EnemyMaster) {
      GridElement.getElement('m')
    }
  }

  "getElement" should "return the expected enum value 'MiniBot' for the given input char 'S'" in {
    expectResult(GridElement.MiniBot) {
      GridElement.getElement('S')
    }
  }

  "getElement" should "return the expected enum value 'EnemyMiniBot' for the given input char 's'" in {
    expectResult(GridElement.EnemyMiniBot) {
      GridElement.getElement('s')
    }
  }

  "getElement" should "return the expected enum value 'Zugar' for the given input char 'P'" in {
    expectResult(GridElement.Zugar) {
      GridElement.getElement('P')
    }
  }

  "getElement" should "return the expected enum value 'Toxifera' for the given input char 'p'" in {
    expectResult(GridElement.Toxifera) {
      GridElement.getElement('p')
    }
  }

  "getElement" should "return the expected enum value 'Fluppet' for the given input char 'B'" in {
    expectResult(GridElement.Fluppet) {
      GridElement.getElement('B')
    }
  }

  "getElement" should "return the expected enum value 'Snorg' for the given input char 'b'" in {
    expectResult(GridElement.Snorg) {
      GridElement.getElement('b')
    }
  }

}
