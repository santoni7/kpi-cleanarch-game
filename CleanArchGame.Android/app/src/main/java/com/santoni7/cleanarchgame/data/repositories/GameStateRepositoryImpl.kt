package com.santoni7.cleanarchgame.data.repositories

import com.google.gson.Gson
import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.GameStateRepository
import com.santoni7.cleanarchgame.game.GameResult
import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.model.GameStatePackage
import io.reactivex.Completable
import io.reactivex.subjects.AsyncSubject
import okhttp3.WebSocket
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.StompClient
import javax.inject.Inject

class GameStateRepositoryImpl @Inject constructor(private val gameApi: GameApi) : GameStateRepository {

    private lateinit var stompClient: StompClient


    override fun sendGameState(gameState: GameState): Completable {
        return Completable.fromAction { stompClient.send("/app/game/start", Gson().toJson(gameState)) }
    }

    override fun <TPlayer, TGameState : GameState> sendGameResults(
            sessionId: Int,
            gameResult: GameResult<TPlayer, TGameState>
        ) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun connect(webSocketUrl: String, connectionToken: String): AsyncSubject<GameStatePackage> {
            stompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, webSocketUrl)
            return AsyncSubject.create<GameStatePackage> {
                stompClient.topic("/user/$connectionToken/queue/game")
            } as AsyncSubject<GameStatePackage>
        }

        override fun disconnect(): Completable {
            return Completable.fromAction { stompClient.disconnect() }
        }
}