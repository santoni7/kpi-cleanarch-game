package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.game.player.RemotePlayer
import io.reactivex.Observable

// Todo: create abstract factory for different games' remote player?
interface FindRemoteOpponentUseCase<T : RemotePlayer>{
    fun findRemoteOpponent(game: GameEntity): Observable<T>
}