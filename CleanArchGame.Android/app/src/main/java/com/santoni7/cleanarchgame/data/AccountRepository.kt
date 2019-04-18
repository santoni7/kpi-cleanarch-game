package com.santoni7.cleanarchgame.data

import com.santoni7.cleanarchgame.model.User

interface AccountRepository {
    var currentUser: User?
}