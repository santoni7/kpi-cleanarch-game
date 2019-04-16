package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.data.network.GameApi
import com.santoni7.cleanarchgame.domain.repositories.LeaderBoardRepository
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Single
import javax.inject.Inject

class LeaderBoardRepositoryImpl @Inject constructor(private val gameApi: GameApi) : LeaderBoardRepository {
    override fun getLeaerBoard(): Single<List<User>>  = gameApi.leaderBoard()
}