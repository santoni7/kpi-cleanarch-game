package com.santoni7.cleanarchgame.api

import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Single
import retrofit2.http.POST

interface ExampleApi{

    @POST("games")
    fun gamesList(): Single<List<GameEntity>>

    // todo:
    // fun leaderboard(): Single<Leaderboard>
}