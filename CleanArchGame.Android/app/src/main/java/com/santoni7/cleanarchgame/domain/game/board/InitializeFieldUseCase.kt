package com.santoni7.cleanarchgame.domain.game.board

import com.santoni7.cleanarchgame.game.GameState

interface InitializeFieldUseCase<TField: GameState> {

    fun initField(field: TField)
}