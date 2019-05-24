package com.santoni7.cleanarchgame.viewmodel

import android.util.Log
import com.santoni7.cleanarchgame.GTAG
import com.santoni7.cleanarchgame.MyApp
import com.santoni7.cleanarchgame.data.AccountRepository
import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.game.checker.CheckerGameManager
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.checker.player.CheckerLocalPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.ui.CheckerUIObserver
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.model.response.StartGameResponse
import com.santoni7.cleanarchgame.util.applySchedulers
import com.santoni7.cleanarchgame.util.applySchedulersForSingle
import com.santoni7.cleanarchgame.viewmodel.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CheckerViewModel : BaseViewModel() {
//    @Inject
//    lateinit var startGameUseCase: StartGameUseCase

    @Inject
    lateinit var findOpponentUseCase: FindOpponentUseCase<CheckerBoard, FigureMove, CheckerPlayer>

    @Inject
    lateinit var accountRepository: AccountRepository

    init {
//        MyApp.component.inject(this)
        MyApp.gameComponent.inject(this)
    }

    val uiObserver: CheckerUIObserver = CheckerUIObserver()

    lateinit var checkerGameManager: CheckerGameManager

    fun onCreate(gameEntity: GameEntity, gameMode: GameMode) {
//        startGameUseCase.startGame(
//            gameEntity,
//            gameMode,
//            listOf(accountRepository.currentUser ?: User.makeAnonymous(), User.makeAnonymous())
//        )
//            .compose(applySchedulersForSingle())
//            .subscribeBy(
//                onSuccess = { response -> onSessionInitialized(response) },
//                onError = { error -> Log.e(GTAG, "CheckerViewModel->onCreate->onError: ${error.message}", error) }
//            ).saveDisposable()
    }

    private fun onSessionInitialized(startGameResponse: StartGameResponse) {
        if (!startGameResponse.status || startGameResponse.session == null)
            return

        findOpponentUseCase.findOpponent(startGameResponse.session, GameMode.LOCAL)
            .compose(applySchedulers())
            .flatMapCompletable { secondPlayer ->
                val hostPlayer =
                    CheckerLocalPlayer(accountRepository.currentUser ?: User.makeAnonymous(), FigureColor.WHITE)
                secondPlayer.setPlayerColor(FigureColor.BLACK)
                checkerGameManager = CheckerGameManager(startGameResponse.session, hostPlayer, secondPlayer,
                    uiObserver = this.uiObserver)

                checkerGameManager.update()
            }
            .subscribeBy(onComplete = {

            }, onError = {})
            .saveDisposable()

    }

    fun onBoardCellClick(x: Int, y: Int) {
        // TODO: Process clicks and then call uiObserver.postAction(...)
    }

}