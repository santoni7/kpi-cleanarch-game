package com.santoni7.cleanarchgame.game

import com.santoni7.cleanarchgame.model.GameSession
import io.reactivex.Completable

interface GameManager {
    fun update(): Completable
    val session: GameSession
}