package com.example.tp1.présentation.list

import com.example.tp1.présentation.list.API.PokemonAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singletons {
    companion object {
        val pokemonAPI: PokemonAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonAPI::class.java)
    }
}
