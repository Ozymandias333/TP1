package com.example.tp1.présentation.list.API

data class PokemonDetailResponse (
    var name: String,
    val types: List<PokemonSlot>
)

data class PokemonSlot (
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)