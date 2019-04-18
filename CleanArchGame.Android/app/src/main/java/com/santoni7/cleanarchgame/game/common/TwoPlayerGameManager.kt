package com.santoni7.cleanarchgame.game.common

import com.santoni7.cleanarchgame.domain.game.ApplyPlayerActionUseCase
import com.santoni7.cleanarchgame.domain.game.CheckGameEndedUseCase
import com.santoni7.cleanarchgame.domain.game.ValidatePlayerActionUseCase
import com.santoni7.cleanarchgame.game.*
import com.santoni7.cleanarchgame.game.player.LocalPlayer
import com.santoni7.cleanarchgame.game.player.Player
import com.santoni7.cleanarchgame.game.player.PlayerType
import com.santoni7.cleanarchgame.game.ui.UIObserver
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject

abstract class TwoPlayerGameManager<TPlayer : Player<TGameState, TPlayerAction>,
        TPlayerAction : PlayerAction,
        TGameState : GameState,
        TUiObserver : UIObserver<TPlayerAction>>(
    val hostPlayer: TPlayer,
    val opponentPlayer: TPlayer,
    var uiObserver: TUiObserver? = null
) : GameManager {

    abstract val validatePlayerActionUseCase: ValidatePlayerActionUseCase<TGameState, TPlayerAction>
    abstract val applyPlayerActionUseCase: ApplyPlayerActionUseCase<TGameState, TPlayerAction>
    abstract val checkGameEndedUseCase: CheckGameEndedUseCase<TGameState>

    val disposables = CompositeDisposable()

    private val _managerState = AsyncSubject.create<ManagerState>().apply {
        onNext(
            ManagerState.CREATING
        )
    }

    val managerState: Observable<ManagerState> = _managerState

//    private val _gameState = AsyncSubject.create<TGameState>()

    override fun update(): Completable =
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

    @Suppress("UNCHECKED_CAST")
    fun invokeMove(player: TPlayer): Completable {
        if (player.type == PlayerType.LOCAL && uiObserver != null) {
            (player as LocalPlayer<TGameState, TPlayerAction, TUiObserver>).setupUiObserver(uiObserver!!)
        }

        return player.nextMove(getGameState())
            .flatMapCompletable { action ->
                if (validatePlayerActionUseCase.validate(getGameState(), action)) {
                    applyPlayerActionUseCase.applyPlayerAction(getGameState(), action)
                } else {
                    Completable.error(IllegalStateException())
                }
            }
            .retry(3) // TODO: Use retry() with predicate (stop retrying when game unexpectedly ended, player disconnected or something else)
            .andThen {
                if (checkGameEndedUseCase.checkGameEnded(getGameState())) {
                    getWinner()
                    _managerState.onNext(ManagerState.FINISHED)
                } else {
                    val nextState: ManagerState = when (_managerState.value) {
                        ManagerState.PLAYER_ONE -> ManagerState.PLAYER_TWO
                        ManagerState.PLAYER_TWO -> ManagerState.PLAYER_ONE
                        null -> throw IllegalStateException("ManagerState cannot be null")
                        else -> _managerState.value!!
                    }
                    _managerState.onNext(nextState)
                }
            }
    }


    abstract fun getGameState(): TGameState

    abstract fun getGameResults(): GameResult<TPlayer, TGameState>

    abstract fun getWinner(): TPlayer?

    abstract fun move(move: TPlayerAction): Boolean

    enum class ManagerState {
        CREATING, PLAYER_ONE, PLAYER_TWO, FINISHED
    }

    fun Disposable.saveDisposable() {
        disposables.add(this)
    }
}