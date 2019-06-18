package com.santoni7.cleanarchgame.game.common

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

interface Figure {

    val color: FigureColor
    val board: Board

    fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell?
    fun canMove(move: FigureMove): Boolean
}