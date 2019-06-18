package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove

class Pawn (val board: CheckerBoard, val color: FigureColor) {
    private var alreadyMoved = false

    fun doesBeatFigure(move: FigureMove): CheckerBoard.Cell?{
        val fromX = move.fromX
        val fromY = move.fromY
        val toX = move.toX
        val toY = move.toY
    }

    fun canMove(move: FigureMove){
        val fromX = move.fromX
        val fromY = move.fromY
        val toX = move.toX
        val toY = move.toY
        if(){

        }

    }
}