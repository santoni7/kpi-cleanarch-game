package com.santoni7.cleanarchgame.di.game

import com.santoni7.cleanarchgame.domain.game.ApplyPlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.CheckGameEndedUseCase
import com.santoni7.cleanarchgame.domain.impl.CheckerUseCasesImpl
import com.santoni7.cleanarchgame.domain.game.ValidatePlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.board.InitializeFieldUseCase
import com.santoni7.cleanarchgame.domain.impl.InitializeCheckersBoardUseCaseImpl
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.common.FigureMove
import dagger.Binds
import dagger.Module

@Module
abstract class CheckerModule {
    /**
     * Binds @Checker-annotated ValidatePlayerActionUseCase<Board, FigureMove> to CheckerUseCasesImpl implementation
     */
    @GameScope @Checker @Binds
    abstract fun bindCheckerValidateMoveUseCase(checkerUseCasesImpl: CheckerUseCasesImpl): ValidatePlayerActionUseCase<Board, FigureMove>

    @GameScope @Checker @Binds
    abstract fun bindCheckerApplyMoveUseCase(checkerUseCasesImpl: CheckerUseCasesImpl): ApplyPlayerActionUseCase<Board, FigureMove>

    @GameScope @Checker @Binds
    abstract fun bindCheckerCheckGameEndedUseCase(checkerUseCasesImpl: CheckerUseCasesImpl): CheckGameEndedUseCase<Board>

    @GameScope @Checker @Binds
    abstract fun bindCheckerBoardInitializeUseCase(initializeCheckersBoardUseCaseImpl: InitializeCheckersBoardUseCaseImpl ): InitializeFieldUseCase<Board>

}