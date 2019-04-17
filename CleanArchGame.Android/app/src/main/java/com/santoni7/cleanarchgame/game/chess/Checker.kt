package com.santoni7.cleanarchgame.game.chess

class Checker(color: FigureColor) : Figure(color) {

    override fun getBeatFigure(board: Board, move: FigureMove): BoardCell? {
        return if(canMove(board, move)) {
            doesBeatFigure(board, move)
        }else null
    }

    private fun doesBeatFigure(board: Board, move: FigureMove): BoardCell? {
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

    override fun canMove(board: Board, move: FigureMove): Boolean {
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
                doesBeatFigure(board, move) != null
            }
        } else return false
    }
}