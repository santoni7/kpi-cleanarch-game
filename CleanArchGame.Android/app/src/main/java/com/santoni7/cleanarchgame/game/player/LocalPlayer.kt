package com.santoni7.cleanarchgame.game.player

import android.util.Log
import com.santoni7.cleanarchgame.game.GameMove
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Observable

abstract class LocalPlayer(val name: String) : Player {
    init {
        Log.d(LocalPlayer::class.simpleName, "Player $name created")
    }

    override fun nextMove(gameMove: GameMove): Observable<GameState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}