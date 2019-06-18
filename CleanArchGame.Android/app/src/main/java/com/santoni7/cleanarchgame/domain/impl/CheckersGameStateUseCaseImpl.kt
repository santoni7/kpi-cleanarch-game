package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.domain.GetGameStateUseCase
import com.santoni7.cleanarchgame.domain.GetGamesUseCase
import com.santoni7.cleanarchgame.domain.SendGameStateUseCase
import com.santoni7.cleanarchgame.game.common.Board
import io.reactivex.Observable

class CheckersGameStateUseCaseImpl: GetGameStateUseCase<Board>, SendGameStateUseCase<Board> {

    override fun getGameState(): Observable<Board> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendGameState(gameState: Board, connectionToken: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}