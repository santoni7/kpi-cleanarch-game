package com.santoni7.cleanarchgame.data

import com.santoni7.cleanarchgame.game.GameResult
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Completable

interface GameStateRepository {
    fun connect(webSocketUrl: String, connectionToken: String): Completable
    fun disconnect(): Completable
    fun sendGameState(deviceId: String, sessionId: Int, gameState: GameState): Completable
    fun <TPlayer, TGameState: GameState> sendGameResults(sessionId: Int, gameResult: GameResult<TPlayer, TGameState>)
}