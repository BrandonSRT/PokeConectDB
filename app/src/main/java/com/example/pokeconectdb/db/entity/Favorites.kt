package com.example.pokeconectdb.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorites(@PrimaryKey val maestroId: Int, val pokeID:String, val imagenURL:String){

}