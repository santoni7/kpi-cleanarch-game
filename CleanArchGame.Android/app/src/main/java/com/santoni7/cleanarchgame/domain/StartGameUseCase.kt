package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.model.response.StartGameResponse
import io.reactivex.Single

interface StartGameUseCase {
    fun startGame(gameEntity: GameEntity, gameMode: GameMode, users: List<User>): Single<StartGameResponse>
}