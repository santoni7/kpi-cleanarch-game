package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.data.repositories.GameEntityRepositoryImpl
import com.santoni7.cleanarchgame.di.game.CheckerModule
import com.santoni7.cleanarchgame.di.game.GameComponent
import com.santoni7.cleanarchgame.ui.MainActivity
import com.santoni7.cleanarchgame.viewmodel.CheckerViewModel
import com.santoni7.cleanarchgame.viewmodel.GameChooseViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [ContextModule::class, NetworkModule::class, RoomModule::class,
    GameCollectionModule::class, FindOpponentModule::class, UserModule::class])
interface AppComponent{
    fun gameComponent(): GameComponent

    fun inject(mainActivity: MainActivity)
    fun inject(checkerViewModel: CheckerViewModel)
    fun inject(gameChooseViewModel: GameChooseViewModel)

    fun inject(gameEntityRepositoryImpl: GameEntityRepositoryImpl)
}