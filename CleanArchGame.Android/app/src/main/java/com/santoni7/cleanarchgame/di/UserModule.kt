package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.data.AccountRepository
import com.santoni7.cleanarchgame.data.repositories.AccountRepositoryImpl
import com.santoni7.cleanarchgame.domain.LoginUseCase
import com.santoni7.cleanarchgame.domain.impl.LoginUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UserModule {
    @Binds @Singleton abstract fun bindAccountRepository(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository

    @Binds @Singleton abstract fun bindLoginUseCase(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase
}