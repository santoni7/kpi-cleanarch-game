package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.domain.impl.FindCheckerOpponentUseCaseImpl
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class FindOpponentModule {
    @Singleton @Binds
    abstract fun bindFindOpponent(findCheckerOpponentUseCaseImpl: FindCheckerOpponentUseCaseImpl):
            FindOpponentUseCase<Board, FigureMove, CheckerPlayer>

}