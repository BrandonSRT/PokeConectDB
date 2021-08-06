package com.example.pokeconectdb.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pokeconectdb.db.dao.UserDAO
import com.example.pokeconectdb.db.entity.User

class UserRepository (private val userDAO: UserDAO) {
    val allUsers: LiveData<List<User>> = userDAO.getAllUsers()

    @WorkerThread
    suspend fun insert(user: User){
        userDAO.insertUser(user)
    }
}