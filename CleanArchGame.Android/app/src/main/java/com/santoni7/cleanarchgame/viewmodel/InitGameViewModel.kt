package com.santoni7.cleanarchgame.viewmodel

import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.viewmodel.base.BaseViewModel
import javax.inject.Inject

class InitGameViewModel : BaseViewModel() {

    @Inject
    lateinit var findOpponentUseCase: FindOpponentUseCase<CheckerBoard, FigureMove, CheckerPlayer>

}