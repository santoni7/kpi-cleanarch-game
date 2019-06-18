package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.GameStateRepository
import com.santoni7.cleanarchgame.game.GameResult
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Completable
import javax.inject.Inject

class GameStateRepositoryImpl @Inject constructor(private val gameApi: GameApi) : GameStateRepository {

    override fun sendGameState(deviceId: String, sessionId: Int, gameState: GameState) = gameApi.sendGameState(sessionId, gameState)

    override fun <TPlayer, TGameState : GameState> sendGameResults(
        sessionId: Int,
        gameResult: GameResult<TPlayer, TGameState>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun connect(webSocketUrl: String, connectionToken: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disconnect(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}