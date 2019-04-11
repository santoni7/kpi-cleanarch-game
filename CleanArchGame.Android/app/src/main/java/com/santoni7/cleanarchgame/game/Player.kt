package com.santoni7.cleanarchgame.game

import io.reactivex.Observable

interface Player {
    fun nextMove(gameState: GameState): Observable<GameState>
}