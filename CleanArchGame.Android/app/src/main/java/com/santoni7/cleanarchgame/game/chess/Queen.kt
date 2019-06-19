package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class Queen (override val color: FigureColor, override val board: Board) : Figure {
    override fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canMove(move: FigureMove): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
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