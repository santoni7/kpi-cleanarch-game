package com.santoni7.cleanarchgame.domain

import com.santoni7.cleanarchgame.model.GamesRecord
import io.reactivex.Single

interface GetLeaderBoardUseCase {

    fun getLeaderBoard(): Single<List<GamesRecord>>
}