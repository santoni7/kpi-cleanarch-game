package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.GameMove
import java.io.Serializable

data class FigureMove(
    val fromX: Int,
    val fromY: Int,
    val toX: Int,
    val toY: Int
) : GameMove, Serializable