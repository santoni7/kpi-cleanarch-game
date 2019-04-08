package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.domain.GetGamesUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.domain.impl.GameCollectionUseCasesImpl
import dagger.Binds
import dagger.Module
import javax.inject.Inject

@Module(includes = [ContextModule::class, NetworkModule::class])
abstract class GameCollectionModule{
    @Binds abstract fun getGamesUseCase(gameCollectionUseCasesImpl: GameCollectionUseCasesImpl): GetGamesUseCase

    @Binds abstract fun startGameUseCase(gameCollectionUseCasesImpl: GameCollectionUseCasesImpl): StartGameUseCase
}