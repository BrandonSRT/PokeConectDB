package com.example.pokeconectdb.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeconectdb.db.PokeDB
import com.example.pokeconectdb.db.entity.Favorites
import com.example.pokeconectdb.db.entity.User
import com.example.pokeconectdb.repository.FavoritesRepository
import com.example.pokeconectdb.repository.UserRepository
import kotlinx.coroutines.launch


class CreateFavoritesViewModel(application: Application) : AndroidViewModel(application) {


    private val db = PokeDB.getDatabase(application.applicationContext)
    private val repository = FavoritesRepository(db.favoriteDao())

    fun insert(maestroId:Int, pokeID: String, imagenURL:String) = viewModelScope.launch{
        repository.insert(Favorites(maestroId, pokeID, imagenURL))

    }
}