package com.santoni7.cleanarchgame.domain.repositories

import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Completable

interface GameStateRepository {
    fun sendGameState(gameState: GameState, gameId: Int): Completable
}