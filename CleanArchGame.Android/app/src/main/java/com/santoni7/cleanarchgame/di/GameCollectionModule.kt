package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.data.GameEntityRepository
import com.santoni7.cleanarchgame.data.GameStateRepository
import com.santoni7.cleanarchgame.data.LeaderBoardRepository
import com.santoni7.cleanarchgame.data.repositories.GameEntityRepositoryImpl
import com.santoni7.cleanarchgame.data.repositories.GameStateRepositoryImpl
import com.santoni7.cleanarchgame.di.game.GameScope
import com.santoni7.cleanarchgame.domain.GetGamesUseCase
import com.santoni7.cleanarchgame.domain.GetLeaderBoardUseCase
import com.santoni7.cleanarchgame.domain.StartGameUseCase
import com.santoni7.cleanarchgame.domain.impl.GameCollectionUseCasesImpl
import com.santoni7.cleanarchgame.domain.impl.GetLeaderBoardUseCaseImpl
import com.santoni7.cleanarchgame.domain.impl.StartCheckerGameImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ContextModule::class, NetworkModule::class])
abstract class GameCollectionModule{
    @Binds @Singleton abstract fun gameEntityRepository(gameEntityRepositoryImpl: GameEntityRepositoryImpl): GameEntityRepository

    @Binds @Singleton abstract fun leaderBoardRepository(leaderBoardRepository: LeaderBoardRepository): LeaderBoardRepository

    @Binds @Singleton abstract fun bindLeaderBoardUseCase(leaderBoardUseCaseImpl: GetLeaderBoardUseCaseImpl): GetLeaderBoardUseCase

    @Binds @Singleton abstract fun getGamesUseCase(gameCollectionUseCasesImpl: GameCollectionUseCasesImpl): GetGamesUseCase

    @Binds @Singleton abstract fun startGameUseCase(startCheckerGameImpl: StartCheckerGameImpl): StartGameUseCase



}