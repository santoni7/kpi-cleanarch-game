package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Single

interface GetGamesUseCase {
    fun getGames(): Single<List<GameEntity>>
}