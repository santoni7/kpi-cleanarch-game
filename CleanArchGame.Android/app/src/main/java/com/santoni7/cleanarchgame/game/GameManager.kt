package com.santoni7.cleanarchgame.game

import com.santoni7.cleanarchgame.game.player.Player

interface GameManager {

    fun initGame(hostPlayer: Player, opponentPlayer: Player)
    fun startGame()
    fun move(move: GameMove): Boolean
    fun checkGameEnd(): Boolean
    fun endGame()
}