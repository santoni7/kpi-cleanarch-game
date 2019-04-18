package com.santoni7.cleanarchgame.game.checker.player

import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.RemotePlayer
import io.reactivex.Single

class CheckerRemotePlayer(webSockerUrl: String, var color: FigureColor = FigureColor.BLACK) : CheckerPlayer, RemotePlayer<CheckerBoard, FigureMove>(webSockerUrl) {

    override fun setPlayerColor(color: FigureColor) {
        this.color = color
    }

    override fun ready(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun nextMove(gameState: CheckerBoard): Single<FigureMove> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}