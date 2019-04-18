package com.santoni7.cleanarchgame.game.checker.player

import android.util.Log
import com.santoni7.cleanarchgame.GTAG
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.LocalPlayer
import com.santoni7.cleanarchgame.game.ui.CheckerUIObserver
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject

class CheckerLocalPlayer(
    val user: User,
    var color: FigureColor = FigureColor.BLACK
) : CheckerPlayer, LocalPlayer<CheckerBoard, FigureMove, CheckerUIObserver>(user.name) {

    var isReady: Boolean = false
    val disposables = CompositeDisposable()

    var currentMove: FigureMove? = null

    var figureMoveSubject = PublishSubject.create<FigureMove>()

    override fun ready(): Boolean = isReady

    override fun nextMove(gameState: CheckerBoard): Single<FigureMove> {
        return figureMoveSubject
            .take(1)
            .singleOrError()
    }

    override fun setupUiObserver(uiObserver: CheckerUIObserver) {
        disposables.clear()
        currentMove = null
        uiObserver.onAction(color)
            .subscribeBy(onNext = {move ->
                figureMoveSubject.onNext(move)
            }, onError = { err ->
                Log.e(GTAG, "CheckerLocalPlayer->setupUiObserver->onError: ${err.message}", err)
            }).saveDisposable()
    }

    override fun setPlayerColor(color: FigureColor) {
        this.color = color
    }

    fun Disposable.saveDisposable() {
        disposables.add(this)
    }
}