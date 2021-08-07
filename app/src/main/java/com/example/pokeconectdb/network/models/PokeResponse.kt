package com.example.pokeconectdb.network.models

data class PokeResponse(val id: Int, val name: String, val sprites: PokeSpriteModel, val types: List<TypesModel> )
