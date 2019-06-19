package com.santoni7.cleanarchgame.game.player

import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction
import com.santoni7.cleanarchgame.model.GameStatePackage
import io.reactivex.Observable

abstract class RemotePlayer<TGameState: GameState, TPlayerAction: PlayerAction> (
    val webSocketUrl: String
) : Player<TGameState, TPlayerAction> {

    private lateinit var gameId: String

    override val type: PlayerType
        get() = PlayerType.REMOTE

    abstract fun onGameStateListener(): Observable<GameStatePackage>
}