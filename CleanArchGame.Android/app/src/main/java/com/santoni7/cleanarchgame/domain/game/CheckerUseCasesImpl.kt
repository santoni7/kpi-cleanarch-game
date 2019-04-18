package com.santoni7.cleanarchgame.domain.game

import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import io.reactivex.Completable
import javax.inject.Inject

@Checker
class CheckerUseCasesImpl @Inject constructor() : ValidatePlayerActionUseCase<CheckerBoard, FigureMove>,
    ApplyPlayerActionUseCase<CheckerBoard, FigureMove>,
    CheckGameEndedUseCase<CheckerBoard> {
    override fun validate(state: CheckerBoard, move: FigureMove): Boolean {
        return state.cells[move.fromX][move.fromY].figure?.let { it.canMove(move) } ?: false
    }

    override fun applyPlayerAction(state: CheckerBoard, move: FigureMove) = Completable.fromAction {
        state.apply {
            val fromCell = cells[move.fromX][move.fromY]
            val toCell = cells[move.toX][move.toY]
            val figure = fromCell.figure
            fromCell.clear()
            toCell.figure = figure

            figure!!
                .getBeatFigure(this, move)
                ?.let { beatFigure -> listOf(beatFigure) } // TODO: get list of all beat figures instead of one figure
                ?.also { figures -> figures.forEach { cell -> removeBeatFigure(cell) } }
        }
    }

    override fun checkGameEnded(gameState: CheckerBoard): Boolean = gameState.cells
        .flatMap { row -> row.filter { cell -> !cell.isFree } } // get all non-free cells and extract figure colors
        .map { cell -> cell.figure!!.color }
        .toHashSet()
        .let { it.size == 1 } // only one color is left on board

}