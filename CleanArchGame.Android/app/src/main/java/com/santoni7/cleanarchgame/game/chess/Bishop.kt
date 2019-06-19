package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class Bishop (override val color: FigureColor, override val board: Board) : Figure {
    override fun getBeatFigure(board: Board, move: FigureMove, figureColor: FigureColor): Board.Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canMove(move: FigureMove) = getAvailableMoves(move, board, color).contains(move)

    companion object{
        fun getAvailableMoves(move: FigureMove, board: Board, color: FigureColor) : Set<FigureMove>{
            val fromX = move.fromX
            val fromY = move.fromY
            val availableMoves = mutableSetOf<FigureMove>()
            val color = move.color
            var xStep = 1
            var yStep = 1
            while (fromX + xStep != Board.BOARD_SIZE && fromY + yStep != Board.BOARD_SIZE){
                if(board.cells[fromX + xStep][fromY + yStep].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX + xStep, fromY + yStep, color)
                }else{
                    if(board.cells[fromX + xStep][fromY + yStep].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY,fromX + xStep, fromY + yStep, color)
                        break
                    }
                }
                xStep++
                yStep++
            }
            xStep = 1
            yStep = 1
            while (fromX - xStep != -1 && fromY + yStep != Board.BOARD_SIZE){
                if(board.cells[fromX - xStep][fromY + yStep].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX - xStep, fromY + yStep, color)
                }else{
                    if(board.cells[fromX - xStep][fromY + yStep].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY,fromX - xStep, fromY + yStep, color)
                        break
                    }
                }
                xStep++
                yStep++
            }
            xStep = 1
            yStep = 1
            while (fromX - xStep != 0 && fromY - yStep != -1){
                if(board.cells[fromX - xStep][fromY - yStep].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX - xStep, fromY - yStep, color)
                }else{
                    if(board.cells[fromX - xStep][fromY - yStep].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY,fromX - xStep, fromY - yStep, color)
                        break
                    }
                }
                xStep++
                yStep++
            }
            xStep = 1
            yStep = 1
            while (fromX + xStep != Board.BOARD_SIZE && fromY - yStep != -1){
                if(board.cells[fromX + xStep][fromY - yStep].isFree){
                    availableMoves += FigureMove(fromX, fromY, fromX + xStep, fromY - yStep, color)
                }else{
                    if(board.cells[fromX + xStep][fromY - yStep].figure!!.color == color)
                        break
                    else{
                        availableMoves += FigureMove(fromX, fromY,fromX + xStep, fromY - yStep, color)
                        break
                    }
                }
                xStep++
                yStep++
            }
            return availableMoves
        }
    }
}