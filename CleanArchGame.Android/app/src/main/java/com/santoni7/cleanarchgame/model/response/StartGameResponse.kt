package com.santoni7.cleanarchgame.model.response

import com.santoni7.cleanarchgame.model.GameSession

data class StartGameResponse(
    val status: Boolean,
    val message: String?, // in case of error
    val session: GameSession?
)
