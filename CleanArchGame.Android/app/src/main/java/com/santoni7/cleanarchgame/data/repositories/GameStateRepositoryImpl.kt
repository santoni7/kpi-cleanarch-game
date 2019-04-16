package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.data.network.GameApi
import com.santoni7.cleanarchgame.domain.repositories.GameStateRepository
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Completable
import javax.inject.Inject

class GameStateRepositoryImpl @Inject constructor(private val gameApi: GameApi): GameStateRepository {
    override fun sendGameState(gameState: GameState, gameId: Int): Completable =
        Completable.create({emitter -> gameApi.sendGameState(gameId, gameState) })
}