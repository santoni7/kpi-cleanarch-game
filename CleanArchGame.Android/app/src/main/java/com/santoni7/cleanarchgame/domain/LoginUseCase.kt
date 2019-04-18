package com.santoni7.cleanarchgame.domain

interface LoginUseCase {
    fun login(token: String)
}