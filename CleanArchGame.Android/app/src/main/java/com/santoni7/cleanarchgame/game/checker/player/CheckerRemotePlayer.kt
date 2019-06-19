package com.santoni7.cleanarchgame.game.checker.player

import com.santoni7.cleanarchgame.MyApp
import com.santoni7.cleanarchgame.data.GameStateRepository
import com.santoni7.cleanarchgame.data.repositories.GameStateRepositoryImpl
import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.Figure
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.RemotePlayer
import com.santoni7.cleanarchgame.model.GameStatePackage
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.subjects.AsyncSubject
import javax.inject.Inject

class CheckerRemotePlayer(
    webSockerUrl: String,
    connectionToken: String,
    var color: FigureColor = FigureColor.BLACK
) : CheckerPlayer, RemotePlayer<Board, FigureMove>(webSockerUrl) {

    @Inject
    @field:Checker
    lateinit var stateRepository: GameStateRepository

    private var gameStateListener: AsyncSubject<GameStatePackage>

    init {
        MyApp.gameComponent.inject(this)
        gameStateListener = stateRepository.connect(webSockerUrl, connectionToken)
    }

    override fun setPlayerColor(color: FigureColor) {
        this.color = color
    }

    override fun ready(): Boolean {
        return true
    }

    override fun onGameStateListener(): Observable<GameStatePackage> {
        return gameStateListener
    }

    override fun nextMove(gameState: Board): Single<FigureMove> {
        return stateRepository.sendGameState(gameState)
            .to {
                gameStateListener.take(1).singleOrError().flatMap { response ->
                    SingleSource<FigureMove> {
                        response.action
                    }
                }
            }
    }
}