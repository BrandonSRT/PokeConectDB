package com.example.pokeconectdb.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.pokeconectdb.db.PokeDB
import com.example.pokeconectdb.db.entity.User
import com.example.pokeconectdb.repository.UserRepository
import kotlinx.coroutines.launch
import java.util.*

class CreateUserViewModel(application: Application) : AndroidViewModel(application) {


    private val db = PokeDB.getDatabase(application.applicationContext)
    private val repository = UserRepository(db.userDao())

    fun insert(id:Int, name: String, lastname:String ,email: String, password:String) = viewModelScope.launch{
      repository.insert(User(id, name, lastname, email, password))
       // repository.insert(User(UUID.randomUUID().toString(), name, lastname, email, password))

    }
}