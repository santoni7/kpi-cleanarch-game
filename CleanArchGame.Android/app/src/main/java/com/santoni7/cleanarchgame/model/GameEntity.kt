package com.santoni7.cleanarchgame.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class GameEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val minSupportedClient: Int
) : Serializable