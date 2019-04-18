package com.santoni7.cleanarchgame.game.player

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction
import io.reactivex.Single

interface Player<TGameState: GameState, TPlayerAction: PlayerAction> {
    fun ready(): Boolean
    fun nextMove(gameState: TGameState): Single<TPlayerAction>
}