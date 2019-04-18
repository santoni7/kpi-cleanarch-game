package com.santoni7.cleanarchgame.game.player

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction

abstract class AIPlayer<TGameState: GameState, TPlayerAction: PlayerAction> : Player<TGameState, TPlayerAction>  {
    override val type: PlayerType
        get() = PlayerType.AI
}