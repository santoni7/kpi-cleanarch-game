package com.santoni7.cleanarchgame.game.common

import com.santoni7.cleanarchgame.domain.game.board.InitializeFieldUseCase
import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.util.make2DArray

class Board(initializer: InitializeFieldUseCase<Board>) : GameState {

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

    val removedFigures = mutableListOf<Figure>()

    init {
        initializer.initField(this)
    }

    fun removeBeatFigure(beatCell: Cell) {
        beatCell.figure!!.let { figure ->
            removedFigures.add(figure)
            beatCell.clear()
        }
    }

    fun forEachCell(action: (Cell)->Unit){
        cells.forEach { row -> row.forEach { action.invoke(it) } }
    }

    fun filterCells(predicate: (Cell)->Boolean) =
        cells.flatMap { row -> row.filter(predicate) }


    class Cell(val x: Int, val y: Int) {
        var figure: Figure? = null
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
    }
}