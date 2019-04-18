package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.game.player.RemotePlayer
import io.reactivex.Observable


interface FindRemoteOpponentUseCase<
        TGameState : GameState,
        TPlayerAction : PlayerAction,
        TPlayer : RemotePlayer<TGameState, TPlayerAction>> {

    fun findRemoteOpponent(game: GameEntity): Observable<TPlayer>
}