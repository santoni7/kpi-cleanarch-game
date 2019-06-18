package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.domain.game.ApplyPlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.CheckGameEndedUseCase
import com.santoni7.cleanarchgame.domain.game.ValidatePlayerActionUseCase
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.FigureMove
import io.reactivex.Completable
import javax.inject.Inject

@Checker
class CheckerUseCasesImpl @Inject constructor() : ValidatePlayerActionUseCase<Board, FigureMove>,
    ApplyPlayerActionUseCase<Board, FigureMove>,
    CheckGameEndedUseCase<Board> {

    override fun validate(state: Board, move: FigureMove): Boolean {
        return state.cells[move.fromX][move.fromY].figure?.let { it.canMove(move) } ?: false
    }

    override fun applyPlayerAction(state: Board, move: FigureMove) = Completable.fromAction {
        state.apply {
            val fromCell = cells[move.fromX][move.fromY]
            val toCell = cells[move.toX][move.toY]
            val figure = fromCell.figure
            fromCell.clear()
            toCell.figure = figure

            figure!!
                .getBeatFigure(this, move, figure.color)
                ?.let { beatFigure -> listOf(beatFigure) }
                ?.also { figures -> figures.forEach { cell -> removeBeatFigure(cell) } }
        }
    }

    override fun checkGameEnded(gameState: Board): Boolean = gameState.cells
        .flatMap { row -> row.filter { cell -> !cell.isFree } } // get all non-free cells and extract figure colors
        .map { cell -> cell.figure!!.color }
        .toHashSet()
        .let { it.size == 1 } // only one color is left on board

}