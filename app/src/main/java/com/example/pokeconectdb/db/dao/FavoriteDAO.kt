package com.example.pokeconectdb.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pokeconectdb.db.entity.Favorites


@Dao
interface FavoriteDAO {
    @Insert
    suspend fun insertFavorite(favorites: Favorites)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): LiveData<List<Favorites>>

}