package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.api.GameApi
import com.santoni7.cleanarchgame.data.LeaderBoardRepository
import com.santoni7.cleanarchgame.domain.GetLeaderBoardUseCase
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.model.UserStatistics
import io.reactivex.Single
import javax.inject.Inject

class GetLeaderBoardUseCaseImpl @Inject constructor(
    private val leaderBoardRepository: LeaderBoardRepository
) : GetLeaderBoardUseCase {

    override fun getLeaderBoard(): Single<List<User>> {
        return  leaderBoardRepository.getLeaerBoard()
    }
}