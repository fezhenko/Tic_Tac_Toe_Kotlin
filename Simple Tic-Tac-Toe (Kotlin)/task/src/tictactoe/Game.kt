package tictactoe


data class Game(
    var gameGrid: MutableList<MutableList<Char>> = mutableListOf(),
    var isFinished: Boolean = false,
)
