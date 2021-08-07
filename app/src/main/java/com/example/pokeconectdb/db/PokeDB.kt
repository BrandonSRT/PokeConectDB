package com.example.pokeconectdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokeconectdb.db.dao.FavoriteDAO
import com.example.pokeconectdb.db.dao.UserDAO
import com.example.pokeconectdb.db.entity.Favorites
import com.example.pokeconectdb.db.entity.User

@Database(entities = [User::class, Favorites::class], version=4, exportSchema = false)
abstract class PokeDB: RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun favoriteDao(): FavoriteDAO

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
