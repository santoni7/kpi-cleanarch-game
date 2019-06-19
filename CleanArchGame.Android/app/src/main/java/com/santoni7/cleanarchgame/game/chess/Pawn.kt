package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class Pawn (override val color: FigureColor, override val board: Board) : Figure{
    override fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell? {
        //empty implementation
        return null
    }

    private var alreadyMoved : Boolean

    init {
        alreadyMoved = false
    }

    fun doesBeatFigure(move: FigureMove): Board.Cell?{
        val fromX = move.fromX
        val fromY = move.fromY
        val toX = move.toX
        val toY = move.toY
        if(board.cells[fromX][fromY].figure!!.color == FigureColor.WHITE){
            if(toX == toX + 1 || toX == toX - 1 && toY == fromY + 1 && !board.cells[toX][toY].isFree && board.cells[toX][toY].figure!!.color != color){
                return board.cells[toX][toY]
            }else return null
        }else{
            if(toX == toX + 1 || toX == toX - 1 && toY == fromY - 1 && !board.cells[toX][toY].isFree && board.cells[toX][toY].figure!!.color != color){
                return board.cells[toX][toY]
            }else return null
        }
    }

    override fun canMove(move: FigureMove) : Boolean{
        val availableMoves = getAvailableMoves(move)
        return if(availableMoves.contains(move)) true
        else false
    }

    fun getAvailableMoves(move: FigureMove) : Set<FigureMove> {
        val fromX = move.fromX
        val fromY = move.fromY
        val availableMoves = mutableSetOf<FigureMove>()
        val color = move.color
        if(color == FigureColor.WHITE){
            if(alreadyMoved == false && board.cells[fromX][fromY + 1].isFree &&
                board.cells[fromX][fromY + 2].isFree)
                availableMoves += FigureMove(fromX, fromY, fromX, fromY + 2, color)
            if(fromY + 1 < Board.BOARD_SIZE){
                if(board.cells[fromX][fromY + 1].isFree)
                    availableMoves += FigureMove(fromX, fromY, fromX, fromY + 1, color)
                if(fromX + 1 < Board.BOARD_SIZE && !board.cells[fromX + 1][fromY + 1].isFree
                    && board.cells[fromX + 1][fromY + 1].figure!!.color != color)
                    availableMoves += FigureMove(fromX, fromY, fromX + 1, fromY + 1, color)
                if(fromX - 1 >= 0 && !board.cells[fromX - 1][fromY + 1].isFree
                    && board.cells[fromX - 1][fromY + 1].figure!!.color != color)
                    availableMoves += FigureMove(fromX, fromY, fromX - 1, fromY + 1, color)
            }
        }else{
            if(alreadyMoved == false && board.cells[fromX][fromY - 1].isFree &&
                board.cells[fromX][fromY - 2].isFree)
                availableMoves += FigureMove(fromX, fromY, fromX, fromY - 2, color)
            if(fromY - 1 >= 0){
                if(board.cells[fromX][fromY - 1].isFree)
                    availableMoves += FigureMove(fromX, fromY, fromX, fromY - 1, color)
                if(fromX + 1 < Board.BOARD_SIZE && !board.cells[fromX + 1][fromY - 1].isFree
                    && board.cells[fromX + 1][fromY - 1].figure!!.color != color)
                    availableMoves += FigureMove(fromX, fromY, fromX + 1, fromY + 1, color)
                if(fromX - 1 >= 0 && !board.cells[fromX - 1][fromY - 1].isFree
                    && board.cells[fromX - 1][fromY - 1].figure!!.color != color)
                    availableMoves += FigureMove(fromX, fromY, fromX - 1, fromY - 1, color)
            }
        }
        return availableMoves
    }
}