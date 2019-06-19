package com.santoni7.cleanarchgame.data

import com.santoni7.cleanarchgame.model.response.StartGameResponse
import io.reactivex.Single

interface UserTokenRepository {

    fun requestUserToken(): Single<StartGameResponse>
}