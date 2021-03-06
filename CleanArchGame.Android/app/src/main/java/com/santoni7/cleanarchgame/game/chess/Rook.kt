package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class Rook (override val color: FigureColor, override val board: Board) : Figure {
    override fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell? {
        return if(!board.cells[move.toX][move.toY].isFree) board.cells[move.toX][move.toY]
        else null
    }

    override fun canMove(move: FigureMove) = getAvailableMoves(move, board, color).contains(move)


    companion object{
        fun getAvailableMoves(move: FigureMove, board: Board, color: FigureColor) : Set<FigureMove>{
            val fromX = move.fromX
            val fromY = move.fromY
            val availableMoves = mutableSetOf<FigureMove>()
            val color = move.color
            var step = 1
            while(fromX - step != -1){
                if(board.cells[fromX - step][fromY].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX - step, fromY, color)
                }else {
                    if(board.cells[fromX - step][fromY].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY, fromX - step, fromY, color)
                        break
                    }
                }
                step++
            }
            step = 1
            while(fromY - step != -1){
                if(board.cells[fromX][fromY - step].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX, fromY - step, color)
                }
                if(!board.cells[fromX][fromY - step].isFree){
                    if(board.cells[fromX][fromY - step].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY, fromX, fromY - step, color)
                        break
                    }
                }
                step++
            }
            step = 1
            while(fromX + step != Board.BOARD_SIZE){
                if(board.cells[fromX + step][fromY].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX + step, fromY, color)
                }
                if(!board.cells[fromX + step][fromY].isFree){
                    if(board.cells[fromX + step][fromY].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY, fromX + step, fromY, color)
                        break
                    }
                }
                step++
            }
            step = 1
            while(fromY + step != Board.BOARD_SIZE){
                if(board.cells[fromX][fromY + step].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX, fromY + step, color)
                }
                if(!board.cells[fromX][fromY + step].isFree){
                    if(board.cells[fromX][fromY + step].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY, fromX, fromY + step, color)
                        break
                    }
                }
                step++
            }
            return availableMoves
        }
    }
}