package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.Const
import com.santoni7.cleanarchgame.data.UserTokenRepository
import com.santoni7.cleanarchgame.domain.FindOpponentUseCase
import com.santoni7.cleanarchgame.game.common.Board
import com.santoni7.cleanarchgame.game.checker.player.CheckerAIPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerLocalPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerPlayer
import com.santoni7.cleanarchgame.game.checker.player.CheckerRemotePlayer
import com.santoni7.cleanarchgame.game.common.FigureMove
import com.santoni7.cleanarchgame.game.player.Player
import com.santoni7.cleanarchgame.game.player.RemotePlayer
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.model.GameSession
import com.santoni7.cleanarchgame.model.User
import com.santoni7.cleanarchgame.util.exception.PlayerNotFoundException
import io.reactivex.Single
import io.reactivex.SingleSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FindCheckerOpponentUseCaseImpl @Inject constructor(
    private val userTokenRepository: UserTokenRepository
) : FindOpponentUseCase<Board, FigureMove, CheckerPlayer> {

    override fun findOpponent(mode: GameMode): Single<CheckerPlayer?> {
            return Single.create {
                when (mode) {
                    GameMode.LOCAL -> findOpponent(mode)
                    GameMode.AI -> CheckerAIPlayer()
                    GameMode.REMOTE -> {
                        userTokenRepository.requestUserToken()
                            .flatMap { startGameResponse ->
                                SingleSource<CheckerRemotePlayer> {
                                    CheckerRemotePlayer(Const.ENDPOINT + "/stomp", startGameResponse.userToken)
                                }
                            }
                    }
                }
            }
        }
    }
