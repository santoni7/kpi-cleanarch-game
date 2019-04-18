package com.santoni7.cleanarchgame.game

import com.santoni7.cleanarchgame.game.player.Player
import java.io.Serializable

abstract class GameResult<TPlayerType, TGameState: GameState>(
    val winner: TPlayerType,
    val looser: TPlayerType,
    val finishState: TGameState
) : Serializable {

}