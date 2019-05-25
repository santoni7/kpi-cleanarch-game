package com.santoni7.cleanarchgame.game.checker.model

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.util.make2DArray

class CheckerBoard : GameState {

    val cells = make2DArray(
        BOARD_SIZE,
        BOARD_SIZE
    ) { i, j -> Cell(i, j) }

    override fun toString(): String {
        var res: String = "\n"
        cells.forEach {row ->
            row.forEach {cell ->
                res += if(!cell.isFree) {
                    if(cell.figure?.color == FigureColor.WHITE) "1 " else "2 "
                }else {
                    "0 "
                }
            }
            res += "\n"
        }
        return res
    }

    val removedFigures = mutableListOf<CheckerFigure>()

    init {
        var xStart: Int
        for (x in 0 until FIGURES_NUMBER / 4 step 1) {
            xStart = x % 2
            for (y in xStart until BOARD_SIZE step 2) {
                cells[x][y].figure =
                    CheckerFigure(this, FigureColor.WHITE)
                cells[BOARD_SIZE - x - 1][y].figure =
                    CheckerFigure(this, FigureColor.BLACK)
            }
        }
    }

    fun getAvailableMoves(color: FigureColor): List<FigureMove> {
        TODO("Not implemented")
    }

    private fun performMove(move: FigureMove, figureColor: FigureColor): List<Cell>? {
        val fromCell = cells[move.fromX][move.fromY]
        val toCell = cells[move.toX][move.toY]
        val figure = fromCell.figure
        fromCell.clear()
        toCell.figure = figure
        // TODO: get list of all beat figures instead of one figure
        return figure!!.getBeatFigure(this, move, figureColor)?.let { beatFigure ->
            listOf(beatFigure)
        }?.also { figures -> figures.forEach { cell -> removeBeatFigure(cell) } }
    }

    fun removeBeatFigure(beatCell: Cell) {
        beatCell.figure!!.let { figure ->
            removedFigures.add(figure)
            beatCell.clear()
        }
    }

    fun checkIsEnded(): Boolean {
        return filterCells { cell -> !cell.isFree } // get all non-free cells and extract figure colors
            .map { cell -> cell.figure!!.color }
            .toHashSet()
            .let { it.size == 1 } // only one color is left on board
    }

    fun forEachCell(action: (Cell)->Unit){
        cells.forEach { row -> row.forEach { action.invoke(it) } }
    }

    fun filterCells(predicate: (Cell)->Boolean) =
        cells.flatMap { row -> row.filter(predicate) }


    class Cell(val x: Int, val y: Int) {
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