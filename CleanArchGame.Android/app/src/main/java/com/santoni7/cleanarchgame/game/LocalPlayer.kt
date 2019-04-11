package com.santoni7.cleanarchgame.game

import android.util.Log
import io.reactivex.Observable

abstract class LocalPlayer(val name: String) : Player {
    init {
        Log.d(LocalPlayer::class.simpleName, "Player $name created")
    }

    override fun nextMove(gameState: GameState): Observable<GameState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}