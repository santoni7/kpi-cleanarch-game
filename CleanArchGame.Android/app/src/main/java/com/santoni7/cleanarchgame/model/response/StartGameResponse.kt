package com.santoni7.cleanarchgame.model.response

import com.google.gson.annotations.SerializedName

data class StartGameResponse(
    @SerializedName("token")
    val userToken: String
)
