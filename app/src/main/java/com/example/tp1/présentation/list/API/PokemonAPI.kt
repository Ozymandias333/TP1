package com.example.tp1.présentation.list.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

///dzniaznfennez

interface PokemonAPI {

    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>?

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: String): Call<PokemonDetailResponse>?
}