package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.GameSession
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.model.response.StartGameResponse
import io.reactivex.Single
import javax.inject.Inject

class StartCheckerGameImpl @Inject constructor(): StartGameUseCase {

    override fun startGame(gameEntity: GameEntity, gameMode: GameMode, users: List<User>): Single<StartGameResponse> {
        return Single.create {
            val response = StartGameResponse(
                ""
            )
            it.onSuccess(response)
        }
    }
}