package com.santoni7.cleanarchgame.model

data class ProgressStatus(val state: ProgressStatus.State, val message: String? = null) {
    enum class State{
        LOADING, DONE, FAIL
    }
}