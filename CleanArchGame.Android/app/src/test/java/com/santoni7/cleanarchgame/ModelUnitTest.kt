package com.santoni7.cleanarchgame

import com.santoni7.cleanarchgame.game.GameManager
import com.santoni7.cleanarchgame.game.chess.ChessGame
import com.santoni7.cleanarchgame.game.player.LocalPlayer
import com.santoni7.cleanarchgame.game.player.Player
import org.junit.Test

class ModelUnitTest {

    @Test
    fun gameInitTest() {
        val game: GameManager = ChessGame()
    }
}