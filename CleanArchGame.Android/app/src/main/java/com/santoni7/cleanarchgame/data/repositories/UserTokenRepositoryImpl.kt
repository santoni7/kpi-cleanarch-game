package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.UserTokenRepository
import com.santoni7.cleanarchgame.model.response.StartGameResponse
import io.reactivex.Single
import javax.inject.Inject

class UserTokenRepositoryImpl @Inject constructor(
    private val gameApi: GameApi
) : UserTokenRepository {

    override fun requestUserToken(): Single<StartGameResponse> {
        return gameApi.requestUerToken()
    }
}