package com.santoni7.cleanarchgame.game.checker.model

import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

open class CheckerFigure(val board: CheckerBoard, val color: FigureColor)// : Figure(color)
{
    // TODO: get list of all beat figures instead of one figure
    open fun getBeatFigure(board: CheckerBoard, move: FigureMove, figureColor: FigureColor): CheckerBoard.Cell? {
        if(figureColor == FigureColor.BLACK) {
            board.cells.reverse()
        }
        return if (canMove(move)) {
            if(figureColor == FigureColor.BLACK) {
                board.cells.reverse()
            }
            doesBeatFigure(move)
        }
        else {
            if(figureColor == FigureColor.BLACK) {
                board.cells.reverse()
            }
            null
        }
    }

    open protected fun doesBeatFigure(move: FigureMove): CheckerBoard.Cell? {
        val fromX = move.fromX
        val fromY = move.fromY
        val toX = move.toX
        val toY = move.toY
        return if (fromX + 2 == toX && fromY + 2 == toY && !board.cells[toX-1][toY -1].isFree &&
            board.cells[toX - 1][toY -1].figure!!.color != color)
                board.cells[toX - 1][toY -1]
        else if(fromX + 2 == toX && fromY - 2 == toY && !board.cells[toX-1][toY + 1].isFree &&
            board.cells[toX - 1][toY + 1].figure!!.color != color)
                board.cells[toX - 1][toY + 1]
        else if(fromX - 2 == toX && fromY + 2 == toY && !board.cells[toX + 1][toY -1].isFree &&
            board.cells[toX + 1][toY - 1].figure!!.color != color)
                board.cells[toX + 1][toY - 1]
        else if(fromX - 2 == toX && fromY - 2 == toY && !board.cells[toX + 1][toY + 1].isFree &&
            board.cells[toX + 1][toY +1].figure!!.color != color)
                board.cells[toX + 1][toY +1]
        else null
    }

    open fun canMove(move: FigureMove): Boolean {
        val fromX = move.fromX
        val fromY = move.fromY
        val toX = move.toX
        val toY = move.toY
        if (board.cells[toX][toY].isFree) {
            if ((fromX + 1 == toX || fromX - 1 == toX) &&
                fromY - 1 == toY) return false
            return if ((fromX + 1 == toX || fromX - 1 == toX) &&
                fromY + 1 == toY) true
            else {
                doesBeatFigure(move) != null
            }
        } else return false
    }
}