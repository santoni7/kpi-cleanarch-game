package com.santoni7.cleanarchgame.game.checker

import android.util.Log
import com.santoni7.cleanarchgame.MyApp
import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.di.game.GameScope
import com.santoni7.cleanarchgame.domain.game.ApplyPlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.CheckGameEndedUseCase
import com.santoni7.cleanarchgame.domain.game.ValidatePlayerActionUseCase
import com.santoni7.cleanarchgame.game.GameResult
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.TwoPlayerGameManager
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.ui.CheckerUIObserver
import com.santoni7.cleanarchgame.model.GameSession
import java.util.*
import javax.inject.Inject

@GameScope
class CheckerGameManager(
    override val session: GameSession,
    hostPlayer: CheckerPlayer,
    opponentPlayer: CheckerPlayer,
    swapColors: Boolean = false,
    uiObserver: CheckerUIObserver? = null
) : TwoPlayerGameManager<CheckerPlayer, FigureMove, CheckerBoard, CheckerUIObserver>(hostPlayer, opponentPlayer, uiObserver) {

    @Inject
    @field:Checker
    override lateinit var validatePlayerActionUseCase: ValidatePlayerActionUseCase<CheckerBoard, FigureMove>

    @Inject
    @field:Checker
    override lateinit var applyPlayerActionUseCase: ApplyPlayerActionUseCase<CheckerBoard, FigureMove>

    @Inject
    @field:Checker
    override lateinit var checkGameEndedUseCase: CheckGameEndedUseCase<CheckerBoard>

    init {
        MyApp.gameComponent.inject(this)
    }

    var board: CheckerBoard =
        CheckerBoard()

    val colorToPlayerMap =
        if (!swapColors) hashMapOf(FigureColor.WHITE to hostPlayer, FigureColor.BLACK to opponentPlayer)
        else hashMapOf(FigureColor.BLACK to hostPlayer, FigureColor.WHITE to opponentPlayer)

    val history = LinkedList<Pair<CheckerPlayer, FigureMove>>()

    override fun getGameResults(): GameResult<CheckerPlayer, CheckerBoard> {
        TODO()
    }

    override fun getWinner(): CheckerPlayer? {
        return getGameState()
            .filterCells { cell -> !cell.isFree } // get all non-free cells and extract figure colors
            .map { cell -> cell.figure!!.color }
            .toHashSet()
            .takeIf { it.size == 1 }
            ?.let { it.first() }
            ?.let { colorToPlayerMap[it] }
    }

    override fun getGameState() = board

    override fun move(move: FigureMove): Boolean {
        if (validatePlayerActionUseCase.validate(board, move)) {
            applyPlayerActionUseCase.applyPlayerAction(board, move)
            Log.e("field", board.toString())
            return true
        }
        //history.add(Pair(player, chessMove))
        return false
    }
}