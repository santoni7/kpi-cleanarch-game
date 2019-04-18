package com.santoni7.cleanarchgame.game.checker

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.chess.FigureColor
import com.santoni7.cleanarchgame.game.chess.FigureMove
import com.santoni7.cleanarchgame.util.make2DArray

class CheckerBoard : GameState {

    val cells = make2DArray(BOARD_SIZE, BOARD_SIZE) { i, j -> Cell() }
    val removedFigures = HashMap<FigureColor, CheckerFigure>()


    init {
        var xStart: Int
        for (y in 0 until FIGURES_NUMBER / 4 step 1) {
            xStart = y % 2
            for (x in xStart until BOARD_SIZE step 2) {
                cells[x][y].figure =
                    CheckerFigure(FigureColor.WHITE)
                cells[x][BOARD_SIZE - y - 1].figure =
                    CheckerFigure(FigureColor.BLACK)
            }
        }
    }

    fun getAvailableMoves(): List<FigureMove> {
        TODO("Not implemented")
    }

//    fun moveFigure(move: FigureMove): Boolean {
//        if(!moveIsValid(move)) return false
//        val beatFigures = performMove(move)
//        //removeBeatFigure(beatFigures)
//        return true
//    }

//    private fun moveIsValid(move: FigureMove): Boolean {
//        if(move.toX < 0 || move.toX >= BOARD_SIZE || move.toY < 0 || move.toY >= BOARD_SIZE) return true
//        val figure: Figure = cells[move.fromX][move.fromY].figure ?: return false
//        if(!figure.canMove(this, move)) return false
//        return true
//    }

    private fun performMove(move: FigureMove): List<Cell>? {
        val fromCell = cells[move.fromX][move.fromY]
        val toCell = cells[move.toX][move.toY]
        val figure = fromCell.figure
        fromCell.clear()
        toCell.figure = figure
        // TODO: get list of all beat figures instead of one figure
        return figure!!.getBeatFigure(this, move)?.let {
                beatFigure -> listOf(beatFigure)
        }?.also { figures -> figures.forEach { cell -> removeBeatFigure(cell) } }
    }

    fun removeBeatFigure(beatCell: Cell) {
        beatCell.figure!!.let { figure ->
            removedFigures[figure.color] = figure
            beatCell.clear()
        }
    }

    //    fun checkGameEnd(): Boolean {
//
//    }
    class Cell {
        var figure: CheckerFigure? = null
            set(value) {
                field = value
                isFree = field == null
            }
        var isFree: Boolean = true

        fun clear() {
            figure = null
        }
    }


    companion object {
        const val BOARD_SIZE = 8
        const val FIGURES_NUMBER = 12
    }
}