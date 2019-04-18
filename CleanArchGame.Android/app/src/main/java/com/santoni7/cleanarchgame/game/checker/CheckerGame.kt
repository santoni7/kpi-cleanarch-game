package com.santoni7.cleanarchgame.game.checker

import com.santoni7.cleanarchgame.MyApp
import com.santoni7.cleanarchgame.game.TwoPlayerGameManager
import com.santoni7.cleanarchgame.game.chess.FigureColor
import com.santoni7.cleanarchgame.game.chess.FigureMove
import java.util.*

class CheckerGame(
    hostPlayer: CheckerPlayer, opponentPlayer: CheckerPlayer
) : TwoPlayerGameManager<CheckerPlayer, FigureMove, CheckerBoard>(hostPlayer, opponentPlayer) {

    val playerMap = hashMapOf<FigureColor, CheckerPlayer>(FigureColor.WHITE to hostPlayer, FigureColor.BLACK to opponentPlayer)

    var board: CheckerBoard =
        CheckerBoard()

    val history = LinkedList<Pair<CheckerPlayer, FigureMove>>()

    init {
        MyApp.gameComponent.inject(this)
    }

    override fun getGameResults(): GameResults<CheckerPlayer> {
        TODO()
    }

    override fun getGameState() = board


    override fun startGame() {

    }

    override fun endGame() {

    }

    override fun move(move: FigureMove): Boolean {
        if (validatePlayerActionUseCase.validate(board, move)) {
            applyPlayerActionUseCase.applyPlayerAction(board, move)
        }
        //history.add(Pair(player, chessMove))
        return true
    }

}