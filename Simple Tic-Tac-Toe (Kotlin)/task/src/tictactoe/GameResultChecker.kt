package tictactoe

class GameResultChecker {

    fun checkGameResult(game: Game) {

        when (checkRowsResult(game)) {
            "Draw" -> {
                game.isFinished = true
                println("Draw")
            }

            "O" -> {
                game.isFinished = true
                println("O wins")
            }

            "X" -> {
                game.isFinished = true
                println("X wins")
            }
        }
    }

    private fun checkRowsResult(game: Game): String {
        for (rowIndex in 0 until game.gameGrid.size) {
            val char = game.gameGrid[rowIndex]
            if (char[0] == char[1] && char[0] == char[2]) {
                return "${char[0]}"
            }
        }
        return checkColumnsResult(game)
    }

    private fun checkColumnsResult(game: Game): String {

        for (rowIndex in 0 until game.gameGrid.size) {
            for (columnIndex in 0 until game.gameGrid[rowIndex].size) {
                val char = game.gameGrid[rowIndex][columnIndex]
                try {

                    if (char == game.gameGrid[rowIndex + 1][columnIndex]
                        && char == game.gameGrid[rowIndex + 2][columnIndex]
                    ) {
                        return "$char"
                    }

                    if (char == game.gameGrid[rowIndex + 1][columnIndex - 1]
                        && char == game.gameGrid[rowIndex + 2][columnIndex - 2]
                    ) {
                        return "$char"
                    }

                    if (char == game.gameGrid[rowIndex + 1][columnIndex + 1]
                        && char == game.gameGrid[rowIndex + 2][columnIndex + 2]
                    ) {
                        return "$char"
                    }

                } catch (e: Exception) {
                    continue
                }
            }
        }
        return checkEmptyColumns(game)
    }

    private fun checkEmptyColumns(game: Game): String {
        val count = game.gameGrid.sumOf { row ->
            row.count { char -> char == '_' }
        }
        return if (count == 0) {
            "Draw"
        } else ""
    }
}
