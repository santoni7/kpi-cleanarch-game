package com.santoni7.cleanarchgame.game.chess

abstract class Figure(val color: FigureColor) {

    abstract fun getBeatFigure(board: Board, move: FigureMove) : BoardCell?
    abstract fun canMove(board: Board, move: FigureMove) : Boolean
}

enum class FigureColor {
    BLACK,
    WHITE
}