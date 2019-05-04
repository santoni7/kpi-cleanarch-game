package com.santoni7.cleanarchgame.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santoni7.cleanarchgame.model.GameEntity

@Database(entities = [GameEntity::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameListDao(): GameListDao
}
