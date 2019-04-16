package com.santoni7.cleanarchgame.domain.repositories

import com.santoni7.cleanarchgame.model.User
import io.reactivex.Single

interface LeaderBoardRepository {
    fun getLeaerBoard(): Single<List<User>>
}