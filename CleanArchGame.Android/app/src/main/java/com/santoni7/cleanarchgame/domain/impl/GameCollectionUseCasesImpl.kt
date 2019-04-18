package com.santoni7.cleanarchgame.domain.impl

import android.util.Log
import com.santoni7.cleanarchgame.GTAG
import com.santoni7.cleanarchgame.api.ExampleApi
import com.santoni7.cleanarchgame.di.Qualifiers
import com.santoni7.cleanarchgame.domain.GetGamesUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.StatusResponse
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Single
import javax.inject.Inject

class GameCollectionUseCasesImpl @Inject constructor(val api: ExampleApi, @Qualifiers.DeviceToken val deviceToken: String) :
        GetGamesUseCase, StartGameUseCase {

    override fun getGames(): Single<List<GameEntity>> {
        // todo replace api call with repository
        return api.gamesList()
            .map { list ->
                Log.d(GTAG, "Got list of games: $list}")
                list
            }
    }

    override fun startGame(gameEntity: GameEntity, gameMode: GameMode, users: List<User>): Single<StatusResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}