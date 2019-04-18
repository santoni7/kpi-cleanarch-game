package com.santoni7.cleanarchgame.game

import com.santoni7.cleanarchgame.di.game.Checker
import com.santoni7.cleanarchgame.domain.game.ApplyPlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.CheckGameEndedUseCase
import com.santoni7.cleanarchgame.domain.game.ValidatePlayerActionUseCase
import com.santoni7.cleanarchgame.game.player.Player
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.AsyncSubject
import javax.inject.Inject

abstract class TwoPlayerGameManager<TPlayer : Player<TGameState, TPlayerAction>, TPlayerAction : PlayerAction, TGameState : GameState>(
    val hostPlayer: TPlayer,
    val opponentPlayer: TPlayer
) {
    @Inject @field:Checker
    lateinit var validatePlayerActionUseCase: ValidatePlayerActionUseCase<TGameState, TPlayerAction>

    @Inject @field:Checker
    lateinit var applyPlayerActionUseCase: ApplyPlayerActionUseCase<TGameState, TPlayerAction>

    @Inject @field:Checker
    lateinit var checkGameEndedUseCase: CheckGameEndedUseCase<TGameState>



    val disposables = CompositeDisposable()

    private val _managerState = AsyncSubject.create<ManagerState>().apply { onNext(ManagerState.CREATING) }

    val managerState: Observable<ManagerState> = _managerState

//    private val _gameState = AsyncSubject.create<TGameState>()

    fun update(): Completable =
        when (_managerState.value) {
            ManagerState.CREATING -> {
                if (hostPlayer.ready() && opponentPlayer.ready()) {
                    _managerState.onNext(ManagerState.PLAYER_ONE)
                }
                Completable.complete()
            }
            ManagerState.PLAYER_ONE -> invokeMove(hostPlayer)
            ManagerState.PLAYER_TWO -> invokeMove(opponentPlayer)
            ManagerState.FINISHED -> Completable.complete()
            else -> Completable.complete()
        }



    fun invokeMove(player: TPlayer): Completable {
//        val gameState = getGameState()
        return player.nextMove(getGameState())
            .flatMapCompletable { action ->
                if (validatePlayerActionUseCase.validate(getGameState(), action)) {
                    applyPlayerActionUseCase.applyPlayerAction(getGameState(), action)
                } else {
                    Completable.error(IllegalStateException())
                }
            }
            .retry(3)
            .andThen {
                if(checkGameEndedUseCase.check(getGameState())){
                    _managerState.onNext(ManagerState.FINISHED)
                }
            }
    }

    abstract fun getGameState(): TGameState
    abstract fun getGameResults(): GameResults<TPlayer>

    //    abstract fun initGame(hostPlayer: TPlayer, opponentPlayer: TPlayer)
    abstract fun startGame()

    abstract fun move(move: TPlayerAction): Boolean
//    abstract fun checkGameEnd(): Boolean
    abstract fun endGame()

    enum class ManagerState {
        CREATING, PLAYER_ONE, PLAYER_TWO, FINISHED
    }

    data class GameResults<PlayerType>(val winner: PlayerType, val looser: PlayerType)
}