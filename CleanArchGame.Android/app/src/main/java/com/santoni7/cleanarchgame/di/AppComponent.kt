package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.ui.MainActivity
import com.santoni7.cleanarchgame.viewmodel.CheckerViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [ContextModule::class, NetworkModule::class, GameCollectionModule::class])
interface AppComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(checkerViewModel: CheckerViewModel)
}