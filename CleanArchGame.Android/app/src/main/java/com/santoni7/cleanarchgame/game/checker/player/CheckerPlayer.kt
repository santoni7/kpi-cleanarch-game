package com.santoni7.cleanarchgame.game.checker.player

import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.Player

interface CheckerPlayer: Player<Board, FigureMove> {
    fun setPlayerColor(color: FigureColor)
}