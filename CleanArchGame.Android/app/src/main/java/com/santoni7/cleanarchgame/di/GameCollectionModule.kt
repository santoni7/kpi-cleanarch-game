package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.data.GameEntityRepository
import com.santoni7.cleanarchgame.data.repositories.GameEntityRepositoryImpl
import com.santoni7.cleanarchgame.domain.GetGamesUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.domain.impl.GameCollectionUseCasesImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ContextModule::class, NetworkModule::class])
abstract class GameCollectionModule{
    @Binds @Singleton abstract fun gameEntityRepository(gameEntityRepositoryImpl: GameEntityRepositoryImpl): GameEntityRepository
    // TODO: Add binding for game state and leaderboard repositories

    @Binds @Singleton abstract fun getGamesUseCase(gameCollectionUseCasesImpl: GameCollectionUseCasesImpl): GetGamesUseCase

    @Binds @Singleton abstract fun startGameUseCase(gameCollectionUseCasesImpl: GameCollectionUseCasesImpl): StartGameUseCase
}