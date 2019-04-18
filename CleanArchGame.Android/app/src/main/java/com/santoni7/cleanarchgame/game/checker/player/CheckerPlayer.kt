package com.santoni7.cleanarchgame.game.checker.player

import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.Player

interface CheckerPlayer: Player<CheckerBoard, FigureMove> {
    fun setPlayerColor(color: FigureColor)
}