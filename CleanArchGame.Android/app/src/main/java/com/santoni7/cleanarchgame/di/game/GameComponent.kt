package com.santoni7.cleanarchgame.di.game

import com.santoni7.cleanarchgame.game.checker.CheckerGameManager
import com.santoni7.cleanarchgame.viewmodel.CheckerViewModel
import dagger.Component

@GameScope
@Component(modules = [CheckerModule::class])
interface GameComponent {
    fun inject(checkerGame: CheckerGameManager)
    fun inject(checkerViewModel: CheckerViewModel)
}