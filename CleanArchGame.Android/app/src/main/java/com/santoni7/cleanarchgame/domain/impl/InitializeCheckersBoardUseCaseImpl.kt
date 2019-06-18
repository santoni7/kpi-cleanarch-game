package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.domain.game.board.InitializeFieldUseCase
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Board.Companion.BOARD_SIZE
import com.santoni7.cleanarchgame.game.checker.model.CheckerFigure
import com.santoni7.cleanarchgame.game.common.FigureColor
import javax.inject.Inject

class InitializeCheckersBoardUseCaseImpl @Inject constructor(): InitializeFieldUseCase<Board> {

    private val FIGURES_NUMBER = 12

    override fun initField(field: Board) {
        var xStart: Int
        for (x in 0 until FIGURES_NUMBER / 4 step 1) {
            xStart = x % 2
            for (y in xStart until BOARD_SIZE step 2) {
                field.cells[x][y].figure =
                    CheckerFigure(FigureColor.WHITE, field)
                field.cells[BOARD_SIZE - x - 1][y].figure =
                    CheckerFigure(FigureColor.BLACK, field)
            }
        }
    }
}