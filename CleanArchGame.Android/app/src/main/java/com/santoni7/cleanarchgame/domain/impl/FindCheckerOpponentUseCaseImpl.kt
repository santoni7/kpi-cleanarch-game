package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.checker.player.CheckerAIPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerLocalPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.GameSession
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.util.exception.PlayerNotFoundException
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FindCheckerOpponentUseCaseImpl @Inject constructor() :
    FindOpponentUseCase<Board, FigureMove, CheckerPlayer> {

    override fun findOpponent(session: String, mode: GameMode) = Single.create<CheckerPlayer?> { emitter ->
        val player: CheckerPlayer? = when (mode) {
            GameMode.LOCAL -> CheckerLocalPlayer(user = User.makeAnonymous())
            GameMode.AI -> CheckerAIPlayer()
            else -> {
                emitter.onError(PlayerNotFoundException())
                null
            }
        }
       player?.let { emitter.onSuccess( it )}
    }

    override fun findOpponent(mode: GameMode): CheckerPlayer? {
            val player: CheckerPlayer? = when (mode) {
                GameMode.LOCAL -> return findOpponent(mode)
                GameMode.AI -> CheckerAIPlayer()
                else -> null
            }
        return player
        }
    }
