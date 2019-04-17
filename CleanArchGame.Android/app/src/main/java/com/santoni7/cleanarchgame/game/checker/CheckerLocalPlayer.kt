package com.santoni7.cleanarchgame.game.checker

import com.santoni7.cleanarchgame.game.GameMove
import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.player.LocalPlayer
import io.reactivex.Observable

class CheckerLocalPlayer(name: String) : LocalPlayer(name) {
    override fun nextMove(gameMove: GameMove): Observable<GameState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}