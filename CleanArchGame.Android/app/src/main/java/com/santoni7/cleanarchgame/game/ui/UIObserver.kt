package com.santoni7.cleanarchgame.game.ui

import com.santoni7.cleanarchgame.game.PlayerAction
import io.reactivex.Observable

interface UIObserver<T: PlayerAction>{
    fun onAction(): Observable<T>
    fun postAction(action: T)
}