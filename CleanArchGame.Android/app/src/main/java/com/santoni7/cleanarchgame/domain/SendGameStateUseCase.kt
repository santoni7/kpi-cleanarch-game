package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.game.GameState

interface SendGameStateUseCase<TGameState: GameState> {

    fun sendGameState(gameState: TGameState, connectionToken: String)
}