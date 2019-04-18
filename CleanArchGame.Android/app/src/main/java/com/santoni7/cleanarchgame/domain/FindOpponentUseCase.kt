package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction
import com.santoni7.cleanarchgame.game.player.Player
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.GameSession
import io.reactivex.Observable


interface FindOpponentUseCase<
        TGameState : GameState,
        TPlayerAction : PlayerAction,
        TPlayer : Player<TGameState, TPlayerAction>> {

    fun findOpponent(session: GameSession, mode: GameMode): Observable<TPlayer>
}