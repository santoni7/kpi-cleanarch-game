package com.santoni7.cleanarchgame.game

class Board {

    companion object{
        const val BOARD_SIZE = 8
    }

    val removedFigures =  ArrayList<Figure>()
    private val cells: Array<Array<BoardCell>> = Array(BOARD_SIZE) { Array(BOARD_SIZE) { BoardCell() } }

    fun moveFigure(move: FigureMove): Boolean {
        if(!moveIsValid(move)) return false
        val beatFigures = performMove(move)
        removeBeatFigures(beatFigures)
        return true
    }

    private fun moveIsValid(move: FigureMove): Boolean {
        if(move.toX < 0 || move.toX >= BOARD_SIZE || move.toY < 0 || move.toY >= BOARD_SIZE) return true
        val figure: Figure = cells[move.fromX][move.fromY].figure ?: return false
        if(!cells[move.toX][move.toY].isFree) return false
        if(!figure.canMove(this, move)) return false
        return true
    }

    private fun performMove(move: FigureMove): List<BoardCell> {
        val fromCell = cells[move.fromX][move.fromY]
        val toCell = cells[move.toX][move.toY]
        val figure = fromCell.figure
        fromCell.clear()
        toCell.figure = figure
        return figure!!.getBeatFigures(this, move)
    }

    private fun removeBeatFigures(beatFigures: List<BoardCell>) {
        var beatCell: BoardCell
        for (cell in beatFigures) {
            beatCell = cell
            removedFigures.add(beatCell.figure!!)
            beatCell.clear()
        }
    }
}