package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.player.Player

class Board {

    companion object {
        const val BOARD_SIZE = 8
        const val FIGURES_NUMBER = 12
    }

    val removedFigures =  HashMap<Player, Figure>()
    val cells: Array<Array<BoardCell>> = Array(BOARD_SIZE) { Array(BOARD_SIZE) { BoardCell() } }

    fun initBoard() {
        var xStart: Int
        for (y in 0 until FIGURES_NUMBER/4 step 1) {
            xStart = y % 2
            for(x in xStart until BOARD_SIZE step 2) {
                cells[x][y].figure = Checker(FigureColor.WHITE)
                cells[x][BOARD_SIZE - y - 1].figure = Checker(FigureColor.BLACK)
            }
        }
    }

    fun moveFigure(move: FigureMove): Boolean {
        if(!moveIsValid(move)) return false
        val beatFigures = performMove(move)
        //removeBeatFigure(beatFigures)
        return true
    }

    private fun moveIsValid(move: FigureMove): Boolean {
        if(move.toX < 0 || move.toX >= BOARD_SIZE || move.toY < 0 || move.toY >= BOARD_SIZE) return true
        val figure: Figure = cells[move.fromX][move.fromY].figure ?: return false
        if(!figure.canMove(this, move)) return false
        return true
    }

    private fun performMove(move: FigureMove): BoardCell? {
        val fromCell = cells[move.fromX][move.fromY]
        val toCell = cells[move.toX][move.toY]
        val figure = fromCell.figure
        fromCell.clear()
        toCell.figure = figure
        return figure!!.getBeatFigure(this, move)
    }

//    fun removeBeatFigure(beatCell: BoardCell?) {
//        beatCell?.let {
//            removedFigures.add(beatCell.figure!!)
//            beatCell.clear()
//        }
//    }

//    fun checkGameEnd(): Boolean {
//
//    }
}