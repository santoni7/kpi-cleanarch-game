package com.santoni7.cleanarchgame.di.game

import com.santoni7.cleanarchgame.game.checker.CheckerGameManager
import com.santoni7.cleanarchgame.presentation.viewmodel.CheckerViewModel
import dagger.Subcomponent

@GameScope
@Subcomponent(modules = [CheckerModule::class])
interface GameComponent {
    fun inject(checkerGame: CheckerGameManager)
    fun inject(checkerViewModel: CheckerViewModel)
}