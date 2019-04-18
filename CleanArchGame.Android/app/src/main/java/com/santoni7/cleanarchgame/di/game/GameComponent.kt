package com.santoni7.cleanarchgame.di.game

import com.santoni7.cleanarchgame.game.checker.CheckerGame
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CheckerModule::class])
interface GameComponent {
    fun inject(checkerGame: CheckerGame)
}