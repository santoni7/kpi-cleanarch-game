package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class Queen (override val color: FigureColor, override val board: Board) : Figure {
    override fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell? {
        return if(!board.cells[move.toX][move.toY].isFree) board.cells[move.toX][move.toY]
        else null
    }

    override fun canMove(move: FigureMove) = getAvailableMoves(move).contains(move)
    fun getAvailableMoves(move: FigureMove) : Set<FigureMove>{
        val availableMoves = mutableSetOf<FigureMove>()
        val obliqueMoves = Rook.getAvailableMoves(move, board, color)
        val straightMoves = Bishop.getAvailableMoves(move, board, color)
        for(item in obliqueMoves){
            availableMoves.add(item)
        }
        for(item in straightMoves){
            availableMoves.add(item)
        }
        return availableMoves
    }
}