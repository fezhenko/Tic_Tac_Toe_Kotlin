package tictactoe

class GridGenerator {

    private val HORIZONTAL_BORDER = "---------"
    private val VERTICAL_BORDER = "|"
    private val INIT_GRID = "_________"
    private val gridMatrix: MutableList<MutableList<Char>> = mutableListOf()

    fun generateGameGrid(): MutableList<MutableList<Char>> {

        val listOfThreeCharsLists = INIT_GRID.chunked(3);

        println(HORIZONTAL_BORDER)
        for ((index, _) in listOfThreeCharsLists.withIndex()) {
            val chars = listOfThreeCharsLists[index].toMutableList()
            printGrid(chars, false)
        }
        println(HORIZONTAL_BORDER)

        return gridMatrix
    }

    fun getCurrentGameGrid(grid: MutableList<MutableList<Char>>) {
        println(HORIZONTAL_BORDER)
        for ((index, _) in grid.withIndex()) {
            val chars = grid[index]
            printGrid(chars, true)
        }
        println(HORIZONTAL_BORDER)
    }

    private fun printGrid(chars: MutableList<Char>, isGridAlreadyCreated: Boolean) {
        val charsList = mutableListOf<Char>()
        print("$VERTICAL_BORDER ")
        for (char in chars) {
            print("$char ")
            charsList.add(char)
        }
        println(VERTICAL_BORDER)
        if (isGridAlreadyCreated) {
            return
        }
        gridMatrix.add(charsList)
    }
}
