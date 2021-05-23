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

    val pokeList : MutableLiveData<List<Pokemon>> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        Singletons.pokemonAPI.getPokemonList()?.enqueue(object : Callback<PokemonListResponse> {
            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                if(response.isSuccessful && response.body() != null) {
                    val pokemonResponse= response.body()!!
                    pokeList.value = pokemonResponse.results
  //                  adapter.updateList(pokemonResponse.results)
                }
            }

        })
    }
}