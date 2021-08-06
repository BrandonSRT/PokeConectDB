package com.example.pokeconectdb.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
//data class User(@PrimaryKey(autoGenerate = true) val id: Int, val name:String, val lastname:String, val email:String, val password:String) {
//}

@Entity
data class User(@PrimaryKey(autoGenerate = true) val id: Int, val name:String, val lastname:String, val email:String, val password:String){

}