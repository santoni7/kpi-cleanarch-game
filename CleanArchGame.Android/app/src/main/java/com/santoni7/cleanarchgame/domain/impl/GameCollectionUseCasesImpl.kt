package com.santoni7.cleanarchgame.domain.impl

import android.util.Log
import com.santoni7.cleanarchgame.data.GameEntityRepository
import com.santoni7.cleanarchgame.domain.GetGamesUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.response.StatusResponse
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.model.response.StartGameResponse
import io.reactivex.Single
import javax.inject.Inject

class GameCollectionUseCasesImpl @Inject constructor(
    val gameEntityRepository: GameEntityRepository
) : GetGamesUseCase {



    override fun getGames(): Single<List<GameEntity>> {
        return gameEntityRepository.gameEntityList()
    }

    companion object {
        val TAG = GameCollectionUseCasesImpl::class.simpleName
    }
}