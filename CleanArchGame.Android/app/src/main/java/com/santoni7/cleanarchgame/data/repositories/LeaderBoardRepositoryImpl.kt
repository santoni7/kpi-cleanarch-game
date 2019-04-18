package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.LeaderBoardRepository
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Single
import javax.inject.Inject

class LeaderBoardRepositoryImpl @Inject constructor(private val gameApi: GameApi) :
    LeaderBoardRepository {
    override fun getLeaerBoard(): Single<List<User>>  = gameApi.leaderBoard()
}