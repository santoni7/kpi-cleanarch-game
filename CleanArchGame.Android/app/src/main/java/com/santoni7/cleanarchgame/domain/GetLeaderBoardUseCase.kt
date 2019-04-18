package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.model.UserStatistics
import io.reactivex.Single

interface GetLeaderBoardUseCase {

    fun getLeaderBoard(): Single<List<UserStatistics>>
}