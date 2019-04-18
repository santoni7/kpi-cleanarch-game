package com.santoni7.cleanarchgame.domain.game

import com.santoni7.cleanarchgame.game.PlayerAction
import com.santoni7.cleanarchgame.game.GameState
import io.reactivex.Completable

interface ApplyPlayerActionUseCase<TGameState: GameState, TPlayerAction: PlayerAction> {
    fun applyPlayerAction(state: TGameState, move: TPlayerAction): Completable
}