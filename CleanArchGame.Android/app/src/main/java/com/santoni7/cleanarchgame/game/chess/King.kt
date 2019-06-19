package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class King (override val color: FigureColor, override val board: Board) : Figure {
    override fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell? {
        return if(!board.cells[move.toX][move.toY].isFree) board.cells[move.toX][move.toY]
        else null
    }

    override fun canMove(move: FigureMove) = getAvailableMoves(move).contains(move)

    fun getAvailableMoves(move: FigureMove): Set<FigureMove>{
        val fromX = move.fromX
        val fromY = move.fromY
        val availableMoves = mutableSetOf<FigureMove>()
        val color = move.color
        if(fromX + 1 < Board.BOARD_SIZE && fromY + 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX + 1][fromY + 1].isFree && board.cells[fromX + 1][fromY + 1].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX + 1, fromY + 1, color))
            }
        }
        if(fromX - 1 < Board.BOARD_SIZE && fromY + 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX - 1][fromY + 1].isFree && board.cells[fromX - 1][fromY + 1].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX - 1, fromY + 1, color))
            }
        }
        if(fromX - 1 < Board.BOARD_SIZE && fromY - 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX - 1][fromY - 1].isFree && board.cells[fromX - 1][fromY - 1].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX - 1, fromY - 1, color))
            }
        }
        if(fromX + 1 < Board.BOARD_SIZE && fromY - 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX + 1][fromY - 1].isFree && board.cells[fromX + 1][fromY - 1].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX + 1, fromY - 1, color))
            }
        }
        if(fromX + 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX + 1][fromY].isFree && board.cells[fromX + 1][fromY].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX + 1, fromY, color))
            }
        }
        if(fromX - 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX - 1][fromY].isFree && board.cells[fromX - 1][fromY].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX - 1, fromY, color))
            }
        }
        if(fromY + 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX][fromY + 1].isFree && board.cells[fromX][fromY + 1].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX, fromY + 1, color))
            }
        }
        if(fromY - 1 < Board.BOARD_SIZE){
            if(!board.cells[fromX][fromY - 1].isFree && board.cells[fromX][fromY - 1].figure!!.color == color)
            else{
                availableMoves.add(FigureMove(fromX, fromY, fromX, fromY - 1, color))
            }
        }
        return availableMoves
    }
}