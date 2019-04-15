package com.santoni7.cleanarchgame.game.chess

abstract class Figure(val colour: FigureColor) {

    abstract fun getBeatFigures(board: Board, move: FigureMove) : List<BoardCell>
    abstract fun canMove(board: Board, move: FigureMove) : Boolean
}

enum class FigureColor {
    BLACK,
    WHITE
}