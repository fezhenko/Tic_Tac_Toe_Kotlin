package tictactoe

import java.util.*

class GameStep {

    private var turnX = true

    fun makeStep(game: Game) {

        val scanner = Scanner(System.`in`)
        while (true) {

            val coordinates = scanner.nextLine()

            try {
                val (x, y) = coordinates.split(" ")
                if (x.toInt() > 3 || y.toInt() > 3 || x.toInt() < 0 || y.toInt() < 0) {
                    throw TypeNotPresentException("", Throwable())
                }

                val indexRow = (x.toInt() - 1)
                val indexColumn = (y.toInt() - 1)

                if (game.gameGrid[indexRow][indexColumn] == '_' && turnX) {
                    game.gameGrid[indexRow][indexColumn] = 'X'
                    turnX = false
                    break
                } else if (game.gameGrid[indexRow][indexColumn] == '_' && !turnX) {
                    game.gameGrid[indexRow][indexColumn] = 'O'
                    turnX = true
                    break
                } else {
                    throw IllegalAccessException()
                }
            } catch (e: IllegalAccessException) {
                println("This cell is occupied! Choose another one!")
            } catch (e: NumberFormatException) {
                println("You should enter numbers!")
            } catch (e: TypeNotPresentException) {
                println("Coordinates should be from 1 to 3!")
            } catch (e: IndexOutOfBoundsException) {
                println("You should enter numbers!")
            }
        }
    }
}
