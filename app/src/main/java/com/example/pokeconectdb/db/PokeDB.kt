package com.example.pokeconectdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokeconectdb.db.dao.UserDAO
import com.example.pokeconectdb.db.entity.User

@Database(entities = [User::class], version=3, exportSchema = false)
abstract class PokeDB: RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object{
        @Volatile
        private var INSTANCE: PokeDB? =null

        fun getDatabase(context: Context): PokeDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    PokeDB::class.java,
                    "PokeDB")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }

        }
    }
}
