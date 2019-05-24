package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.MyApp
import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.GameEntityRepository
import com.santoni7.cleanarchgame.database.GameListDao
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.util.isOnline
import io.reactivex.Single
import javax.inject.Inject

class GameEntityRepositoryImpl @Inject constructor(
    private val gameApi: GameApi,
    private val gamesDao: GameListDao
) : GameEntityRepository {

    companion object {
        private const val CONNECT_TIMEOUT: Long = 2000
    }

    init {
        MyApp.component.inject(this)
    }

    override fun getGameEntity(id: Int): Single<GameEntity> {
        return if(isOnline(CONNECT_TIMEOUT)) {
            gameApi.gameEntityList()
                .flatMapCompletable { gamesDao.insertGames(it) }
                .andThen(gamesDao.getGame(id))
        }else  gamesDao.getGame(id)
    }

    override fun gameEntityList(): Single<List<GameEntity>> {
        return if(isOnline(CONNECT_TIMEOUT)) {
            gameApi.gameEntityList()
                .flatMapCompletable {
                    gamesDao.clearTable()
                    gamesDao.insertGames(it)
                }
                .andThen(gamesDao.getGames())
        }else  gamesDao.getGames()
    }
}