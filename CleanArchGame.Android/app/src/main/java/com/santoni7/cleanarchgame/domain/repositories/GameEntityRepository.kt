package com.santoni7.cleanarchgame.domain.repositories

import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Single

interface GameEntityRepository {
    fun getGameEntity(id: Int): Single<GameEntity>
}