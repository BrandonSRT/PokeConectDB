package com.example.pokeconectdb.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pokeconectdb.db.PokeDB
import com.example.pokeconectdb.db.entity.User
import com.example.pokeconectdb.repository.UserRepository

class UserListViewModel (application: Application) : AndroidViewModel(application) {
    private val db = PokeDB.getDatabase(application.applicationContext)
    private val repository = UserRepository(db.userDao())

    fun fetchUsers(): LiveData<List<User>> = repository.allUsers
}