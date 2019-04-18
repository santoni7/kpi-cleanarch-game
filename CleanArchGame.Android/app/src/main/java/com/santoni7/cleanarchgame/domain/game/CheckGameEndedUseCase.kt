package com.santoni7.cleanarchgame.domain.game

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction

interface CheckGameEndedUseCase<TGameState: GameState> {
    fun check(gameState:TGameState): Boolean
}