package com.santoni7.cleanarchgame.domain.game

import com.santoni7.cleanarchgame.game.PlayerAction
import com.santoni7.cleanarchgame.game.GameState

interface ValidatePlayerActionUseCase<TGameState: GameState, TPlayerAction: PlayerAction> {
    fun validate(state: TGameState, move: TPlayerAction): Boolean
}