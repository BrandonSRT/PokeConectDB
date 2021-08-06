package com.example.pokeconectdb.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pokeconectdb.db.dao.FavoriteDAO
import com.example.pokeconectdb.db.entity.Favorites


class FavoritesRepository (private val favoriteDAO: FavoriteDAO) {
    val allFavorites: LiveData<List<Favorites>> = favoriteDAO.getAllFavorites()

    @WorkerThread
    suspend fun insert(favorites: Favorites){
        favoriteDAO.insertFavorite(favorites)
    }
}