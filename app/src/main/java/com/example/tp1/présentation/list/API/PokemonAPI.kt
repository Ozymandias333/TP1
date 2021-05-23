package com.example.tp1.présentation.list.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//d,le,flef,oe,foe

interface PokemonAPI {

    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>?

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: String): Call<PokemonDetailResponse>?
}