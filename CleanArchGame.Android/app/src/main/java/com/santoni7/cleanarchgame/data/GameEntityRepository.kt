package com.santoni7.cleanarchgame.data

import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Single

interface GameEntityRepository {
    fun gameEntityList(): Single<List<GameEntity>>
    fun getGameEntity(id: Int): Single<GameEntity>
}