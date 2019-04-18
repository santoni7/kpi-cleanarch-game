package com.santoni7.cleanarchgame.di.game

import com.santoni7.cleanarchgame.domain.game.ApplyPlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.CheckGameEndedUseCase
import com.santoni7.cleanarchgame.domain.game.CheckerUseCasesImpl
import com.santoni7.cleanarchgame.domain.game.ValidatePlayerActionUseCase
import com.santoni7.cleanarchgame.game.checker.CheckerBoard
import com.santoni7.cleanarchgame.game.chess.FigureMove
import dagger.Binds
import dagger.Module

@Module
abstract class CheckerModule {
    /**
     * Binds @Checker-annotated ValidatePlayerActionUseCase<CheckerBoard, FigureMove> to CheckerUseCasesImpl implementation
     */
    @Checker @Binds
    abstract fun bindCheckerValidateMoveUseCase(checkerUseCasesImpl: CheckerUseCasesImpl): ValidatePlayerActionUseCase<CheckerBoard, FigureMove>

    @Checker @Binds
    abstract fun bindCheckerApplyMoveUseCase(checkerUseCasesImpl: CheckerUseCasesImpl): ApplyPlayerActionUseCase<CheckerBoard, FigureMove>

    @Checker @Binds
    abstract fun bindCheckerCheckGameEndedUseCase(checkerUseCasesImpl: CheckerUseCasesImpl): CheckGameEndedUseCase<CheckerBoard>
}