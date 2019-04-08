package com.santoni7.cleanarchgame.model

data class GameEntity(
    val id: Int,
    val title: String,
    val description: String,
    val minSupportedClient: Int
)