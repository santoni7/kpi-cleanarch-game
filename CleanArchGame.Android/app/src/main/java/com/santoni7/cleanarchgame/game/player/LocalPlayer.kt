package com.santoni7.cleanarchgame.game.player

import android.util.Log
import com.santoni7.cleanarchgame.game.GameState
import com.santoni7.cleanarchgame.game.PlayerAction
import com.santoni7.cleanarchgame.game.ui.UIObserver

abstract class LocalPlayer<TGameState: GameState, TPlayerAction: PlayerAction, TUIObserver: UIObserver<TPlayerAction>>(
    val name: String
) : Player<TGameState, TPlayerAction> {
    override val type: PlayerType
        get() = PlayerType.LOCAL

    abstract fun setupUiObserver(uiObserver: TUIObserver)

    init {
        Log.d(LocalPlayer::class.simpleName, "Local player \"$name\" created")
    }
}