package com.santoni7.cleanarchgame.game.checker.player

import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.AIPlayer
import io.reactivex.Single

class CheckerAIPlayer(var color: FigureColor = FigureColor.BLACK) : CheckerPlayer, AIPlayer<CheckerBoard, FigureMove>() {
    override fun ready() = true

    override fun setPlayerColor(color: FigureColor) {
        this.color = color
    }

    override fun nextMove(gameState: CheckerBoard): Single<FigureMove> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}