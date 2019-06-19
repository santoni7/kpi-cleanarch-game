package com.santoni7.cleanarchgame.presentation.viewmodel

import android.util.Log
import com.santoni7.cleanarchgame.GTAG
import com.santoni7.cleanarchgame.MyApp
import com.santoni7.cleanarchgame.data.AccountRepository
import com.santoni7.cleanarchgame.data.UserTokenRepository
import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.game.checker.CheckerGameManager
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.checker.player.CheckerLocalPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.ui.CheckerUIObserver
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.ProgressStatus
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.model.response.StartGameResponse
import com.santoni7.cleanarchgame.util.applySchedulersForSingle
import com.santoni7.cleanarchgame.presentation.viewmodel.base.BaseViewModel
import com.santoni7.cleanarchgame.util.JWTUtils
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CheckerViewModel : BaseViewModel() {
    @Inject
    lateinit var startGameUseCase: StartGameUseCase

    @Inject
    lateinit var findOpponentUseCase: FindOpponentUseCase<Board, FigureMove, CheckerPlayer>

    init {
        MyApp.gameComponent.inject(this)
    }

    val uiObserver: CheckerUIObserver = CheckerUIObserver()

    lateinit var checkerGameManager: CheckerGameManager

    fun onCreate(gameMode: GameMode) {
        onSessionInitialized(gameMode)
    }

    private fun onSessionInitialized(
        gameMode: GameMode
    ) {
        findOpponentUseCase.findOpponent(gameMode)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapCompletable { secondPlayer ->
                val hostPlayer =
                    CheckerLocalPlayer(User.makeAnonymous(), FigureColor.WHITE)
                secondPlayer.setPlayerColor(FigureColor.BLACK)
                checkerGameManager = CheckerGameManager(hostPlayer, secondPlayer,
                    uiObserver = this.uiObserver)
                Log.e("field", checkerGameManager.board.toString())
                checkerGameManager.update()
            }
            .subscribeBy(onComplete = {

            }, onError = {})
            .saveDisposable()
    }

    fun onBoardCellClick(fromX: Int, fromY: Int, toX: Int, toY: Int, color: FigureColor) {
        uiObserver.postAction(
            FigureMove(
            fromX,
            fromY,
            toX,
            toY,
            color
        ))
        checkerGameManager.update()
    }
}