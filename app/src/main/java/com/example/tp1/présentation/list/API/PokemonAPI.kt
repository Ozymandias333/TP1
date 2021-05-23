package com.example.tp1.présentation.list.API

import retrofit2.Call
import retrofit2.http.GET

interface PokemonAPI {

    @GET("pokemon")
    fun getPokemonList(): Call<PokemonResponse>?
}