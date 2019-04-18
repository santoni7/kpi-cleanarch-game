package com.santoni7.cleanarchgame.domain.game

import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.game.checker.CheckerBoard
import com.santoni7.cleanarchgame.game.chess.FigureMove
import io.reactivex.Completable
import javax.inject.Inject

@Checker
class CheckerUseCasesImpl @Inject constructor() :
    ValidatePlayerActionUseCase<CheckerBoard, FigureMove>,
    ApplyPlayerActionUseCase<CheckerBoard, FigureMove>,
    CheckGameEndedUseCase<CheckerBoard>
{
    override fun validate(state: CheckerBoard, move: FigureMove): Boolean {
        // todo
        return false
    }

    override fun applyPlayerAction(state: CheckerBoard, move: FigureMove): Completable {
        TODO("not implemented")
    }

    override fun check(gameState: CheckerBoard): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}