package com.santoni7.cleanarchgame.game.ui

import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.common.FigureMove
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class CheckerUIObserver : UIObserver<FigureMove>{
    private val actionSubject = PublishSubject.create<FigureMove>()

    override fun onAction(): Observable<FigureMove> = actionSubject


    fun onAction(color: FigureColor): Observable<FigureMove> =
        actionSubject.filter { action -> action.color == color }



    override fun postAction(action: FigureMove) {
        actionSubject.onNext(action)
    }
}