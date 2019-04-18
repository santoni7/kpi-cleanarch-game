package com.santoni7.cleanarchgame.domain.game

import com.santoni7.cleanarchgame.game.GameResult
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Completable

interface SendGameResultsUseCase<TPlayer, TGameState: GameState, TGameResult: GameResult<TPlayer, TGameState>> {
    fun sendGameResults(gameResult: TGameResult): Completable
}
