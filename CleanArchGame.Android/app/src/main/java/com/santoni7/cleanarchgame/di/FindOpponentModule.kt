package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.domain.impl.FindCheckerOpponentUseCaseImpl
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class FindOpponentModule {
    @Singleton @Binds
    abstract fun bindFindOpponent(findCheckerOpponentUseCaseImpl: FindCheckerOpponentUseCaseImpl): FindOpponentUseCase<CheckerBoard, FigureMove, CheckerPlayer>

}