package com.example.tp1.présentation.list.API

import com.example.tp1.présentation.list.List.Pokemon

data class PokemonResponse(

    val count: Int,
    val next: String,
    val results: List<Pokemon>
)
