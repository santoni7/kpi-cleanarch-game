package com.santoni7.cleanarchgame.data.repositories

import com.santoni7.cleanarchgame.data.AccountRepository
import com.santoni7.cleanarchgame.model.User
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor() : AccountRepository {
    override var currentUser: User?
        get() = TODO("NOT IMPLEMENTED") //todo!! use sharedprefs property delegate
        set(value) = TODO()
}