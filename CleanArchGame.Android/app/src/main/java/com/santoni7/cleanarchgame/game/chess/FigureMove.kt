package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.PlayerAction

data class FigureMove(
    val fromX: Int,
    val fromY: Int,
    val toX: Int,
    val toY: Int
) : PlayerAction