package com.santoni7.cleanarchgame.game.checker

import com.santoni7.cleanarchgame.game.chess.FigureMove
import io.reactivex.Single

class CheckerLocalPlayer(name: String) : CheckerPlayer {
    var isReady: Boolean = false

    override fun ready(): Boolean = isReady

    override fun nextMove(gameState: CheckerBoard): Single<FigureMove> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}