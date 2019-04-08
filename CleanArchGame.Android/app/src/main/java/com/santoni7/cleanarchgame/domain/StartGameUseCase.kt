package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.StatusResponse
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Single

interface StartGameUseCase {
    // todo think about params
    fun startGame(gameEntity: GameEntity, gameMode: GameMode, users: List<User>): Single<StatusResponse>
}