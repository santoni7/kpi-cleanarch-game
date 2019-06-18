package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.data.repositories.GameEntityRepositoryImpl
import com.santoni7.cleanarchgame.di.game.GameComponent
import com.santoni7.cleanarchgame.presentation.ui.MainActivity
import com.santoni7.cleanarchgame.presentation.viewmodel.CheckerViewModel
import com.santoni7.cleanarchgame.presentation.viewmodel.StartViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [ContextModule::class, NetworkModule::class, RoomModule::class,
    GameCollectionModule::class, FindOpponentModule::class, UserModule::class])
interface AppComponent{
    fun gameComponent(): GameComponent

    fun inject(mainActivity: MainActivity)
    fun inject(checkerViewModel: CheckerViewModel)
    fun inject(gameChooseViewModel: StartViewModel)

    fun inject(gameEntityRepositoryImpl: GameEntityRepositoryImpl)
}