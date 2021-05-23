package com.example.tp1.présentation.list.List

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp1.présentation.list.API.PokemonListResponse
import com.example.tp1.présentation.list.Singletons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListViewModel : ViewModel(){

    val pokeList : MutableLiveData<PokemonModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList.value = PokemonLoader
        Singletons.pokemonAPI.getPokemonList()?.enqueue(object : Callback<PokemonListResponse> {
            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                pokeList.value = PokemonError

            }

            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                if(response.isSuccessful && response.body() != null) {
                    val pokemonResponse= response.body()!!
                    pokeList.value = PokemonSucces(pokemonResponse.results)
                } else {
                    pokeList.value = PokemonError
                }
            }

        })
    }
}