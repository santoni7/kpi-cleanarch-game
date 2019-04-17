package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.data.network.GameApi
import com.santoni7.cleanarchgame.domain.repositories.GameEntityRepository
import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Single
import javax.inject.Inject

class GameEntityRepositoryImpl public @Inject constructor(private val gameApi: GameApi): GameEntityRepository {
    override fun getGameEntity(id: Int): Single<GameEntity> = gameApi.gameEntity(id)
}