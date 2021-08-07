package com.example.pokeconectdb.network

import com.example.pokeconectdb.network.models.PokeResponse
import com.example.pokeconectdb.network.models.PokelistResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon/{name}")
    fun getCurrentPokemon(@Path("name") name: String) : Call<PokeResponse>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokelistResponse>

}