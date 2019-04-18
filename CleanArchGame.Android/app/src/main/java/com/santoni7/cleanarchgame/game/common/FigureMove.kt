package com.santoni7.cleanarchgame.game.common

import com.santoni7.cleanarchgame.game.PlayerAction

data class FigureMove(
    val fromX: Int,
    val fromY: Int,
    val toX: Int,
    val toY: Int,
    val color: FigureColor
) : PlayerAction {
    val pointFrom: Point
        get() = Point(fromX, fromY)
    val pointTo: Point
        get() = Point(toX, toY)
}