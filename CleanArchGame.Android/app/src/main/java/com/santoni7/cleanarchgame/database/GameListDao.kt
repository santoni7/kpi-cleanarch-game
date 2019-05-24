package com.santoni7.cleanarchgame.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.santoni7.cleanarchgame.model.GameEntity
import io.reactivex.Completable
import io.reactivex.Single
import androidx.room.Delete
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

@Dao
interface GameListDao {

    @Query("SELECT * FROM gameEntity")
    fun getGames(): Single<List<GameEntity>>

    @Query("SELECT * FROM gameEntity WHERE id = :id")
    fun getGame(id: Int): Single<GameEntity>

    @Insert(onConflict = REPLACE)
    fun insertGames(games: List<GameEntity>): Completable

    @Insert(onConflict = REPLACE)
    fun insertGame(game: GameEntity): Completable

    @Update
    fun update(game: GameEntity)

    @Delete
    fun delete(games: List<GameEntity>)

    @Query("DELETE FROM gameEntity")
    fun clearTable()

}