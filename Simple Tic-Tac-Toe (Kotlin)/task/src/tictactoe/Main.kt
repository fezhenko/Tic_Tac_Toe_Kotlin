package tictactoe

fun main() {

    val gridGenerator = GridGenerator();
    val game = Game(gridGenerator.generateGameGrid())
    val gameStep = GameStep();
    val gameResultChecker = GameResultChecker();

    while (!game.isFinished) {
        gameStep.makeStep(game)
        gridGenerator.getCurrentGameGrid(game.gameGrid)
        gameResultChecker.checkGameResult(game)
    }
}
