package com.santoni7.cleanarchgame.game.player

import com.santoni7.cleanarchgame.game.GameMove
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Observable

interface Player {
    fun nextMove(gameMove: GameMove): Observable<GameState>
}