package com.example.tp1.présentation.list

import android.content.Context
import com.example.tp1.présentation.list.API.PokemonAPI
import com.example.tp1.présentation.list.PokeApplication.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singletons {
    companion object {

        var cache: Cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024 )

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val pokemonAPI: PokemonAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(PokemonAPI::class.java)


    }
}
