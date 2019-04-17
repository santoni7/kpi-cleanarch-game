package com.santoni7.cleanarchgame.data.network

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GameApi {
    @GET("/party/{gameEntityID}")
     fun gameEntity(@Path("gameEntityId") gameEntityId: Int): Single<GameEntity>

    @GET("/leaderBoard")
    fun leaderBoard(): Single<List<User>>

    @POST("/party/{gameEntityID}/gameState")
    fun sendGameState(@Path("gameEntityId") gameEntityId: Int, gameState: GameState): Completable
}