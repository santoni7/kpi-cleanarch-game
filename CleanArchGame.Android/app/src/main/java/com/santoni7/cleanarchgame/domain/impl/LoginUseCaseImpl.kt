package com.santoni7.cleanarchgame.domain.impl

import com.santoni7.cleanarchgame.data.AccountRepository
import com.santoni7.cleanarchgame.domain.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    val accountRepository: AccountRepository
) : LoginUseCase {
    override fun login(token: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}