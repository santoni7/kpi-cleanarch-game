package com.santoni7.cleanarchgame.model

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction

data class GameStatePackage(
    val gameState: GameState,
    val userId: String,
    val action: PlayerAction

)