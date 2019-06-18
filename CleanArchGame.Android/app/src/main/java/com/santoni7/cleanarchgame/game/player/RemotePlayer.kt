package com.santoni7.cleanarchgame.game.player

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction

abstract class RemotePlayer<TGameState: GameState, TPlayerAction: PlayerAction> (
    val connectionToken: String,
    val webSocketUrl: String
) : Player<TGameState, TPlayerAction> {
    // TODO: Initialize socket connection
    override val type: PlayerType
        get() = PlayerType.REMOTE
}