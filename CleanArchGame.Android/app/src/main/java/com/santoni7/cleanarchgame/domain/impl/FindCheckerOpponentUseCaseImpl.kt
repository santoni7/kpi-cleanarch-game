package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.game.checker.model.CheckerBoard
import com.santoni7.cleanarchgame.game.checker.player.CheckerAIPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerLocalPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerRemotePlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.GameSession
import com.santoni7.cleanarchgame.model.User
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FindCheckerOpponentUseCaseImpl @Inject constructor() :
    FindOpponentUseCase<CheckerBoard, FigureMove, CheckerPlayer> {

    override fun findOpponent(session: GameSession, mode: GameMode) = Observable.create<CheckerPlayer> { emitter ->
        val player: CheckerPlayer = when (mode) {
            GameMode.LOCAL -> CheckerLocalPlayer(user = User.makeAnonymous())
            GameMode.AI -> CheckerAIPlayer()
            GameMode.REMOTE -> CheckerRemotePlayer(session.webSocketRoomUrl ?: "")
        }
        emitter.onNext(player)
    }
}