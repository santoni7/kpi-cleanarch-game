package com.santoni7.cleanarchgame.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import androidx.room.Room
import android.app.Application
import android.content.Context
import com.santoni7.cleanarchgame.database.AppDatabase
import com.santoni7.cleanarchgame.database.GameListDao


@Module
class RoomModule {

    @Singleton
    @Provides
    internal fun providesRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "clean-db").build()
    }

    @Singleton
    @Provides
    internal fun providesGameListDao(demoDatabase: AppDatabase): GameListDao {
        return demoDatabase.gameListDao()
    }
}