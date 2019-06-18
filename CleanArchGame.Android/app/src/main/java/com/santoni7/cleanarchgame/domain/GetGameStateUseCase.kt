package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Observable
import io.reactivex.Single

interface GetGameStateUseCase<TGameState: GameState> {

    fun getGameState(): Observable<TGameState>
}