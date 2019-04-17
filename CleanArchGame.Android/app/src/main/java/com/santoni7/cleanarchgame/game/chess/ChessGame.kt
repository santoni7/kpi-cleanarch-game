package com.santoni7.cleanarchgame.game.chess

import com.santoni7.cleanarchgame.game.GameManager
import com.santoni7.cleanarchgame.game.GameMove
import com.santoni7.cleanarchgame.game.player.Player
import java.util.*

class ChessGame : GameManager {
    private val board: Board = Board()
    private lateinit var hostPlayer: Player
    private lateinit var opponentPlayer: Player
    val history =  LinkedList<Pair<Player, FigureMove>>()

    override fun initGame(hostPlayer: Player, opponentPlayer: Player) {
        this.hostPlayer = hostPlayer
        this.opponentPlayer = opponentPlayer
    }

    override fun startGame() {

    }

    override fun endGame() {

    }

    override fun move(move: GameMove): Boolean {
        val chessMove = if(move is FigureMove) move else return false
        if(!board.moveFigure(chessMove)) return false
        //history.add(Pair(player, chessMove))
        return true
    }

    override fun checkGameEnd(): Boolean {
        //return board.checkGameEnd()

        return true
    }
}