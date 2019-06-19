package com.santoni7.cleanarchgame.data

import com.santoni7.cleanarchgame.game.GameResult
import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.model.GameStatePackage
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject

interface GameStateRepository {
    fun connect(webSocketUrl: String, connectionToken: String): AsyncSubject<GameStatePackage>
    fun disconnect(): Completable
    fun sendGameState(gameState: GameState): Completable
    fun <TPlayer, TGameState: GameState> sendGameResults(sessionId: Int, gameResult: GameResult<TPlayer, TGameState>)
}