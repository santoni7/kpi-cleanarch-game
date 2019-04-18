package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.GameEntityRepository
import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Single
import javax.inject.Inject

// TODO: Use local database along with api to cache game entities for offline usage
class GameEntityRepositoryImpl @Inject constructor(private val gameApi: GameApi) : GameEntityRepository {

    override fun getGameEntity(id: Int): Single<GameEntity> = gameApi.gameEntity(id)

    override fun gameEntityList(): Single<List<GameEntity>> = gameApi.gameEntityList()
}