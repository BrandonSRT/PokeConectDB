package com.example.pokeconectdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeconectdb.network.RetrofitProvider
import com.example.pokeconectdb.network.models.PokelistResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListViewModel: ViewModel() {
    private val retrofitProvider = RetrofitProvider()

    private val _currentPokeLiveData = MutableLiveData<PokelistResponse>()
    val currentPokeLiveData: LiveData<PokelistResponse> = _currentPokeLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _serverError = MutableLiveData<Boolean>()
    val serverError: LiveData<Boolean> = _serverError

    fun fetchPokeListData() {
        _isLoading.postValue(true)
        retrofitProvider.getApiService()
            .getPokemonList(100,0)
            .enqueue(object : Callback<PokelistResponse> {
                override fun onResponse(
                    call: Call<PokelistResponse>,
                    response: Response<PokelistResponse>
                ) {
                    _isLoading.postValue(false)
                    if (response.isSuccessful) {
                        _currentPokeLiveData.postValue(response.body())
                    } else {
                        // Servidor falla, por varias razones, por ejemplo, no se armo bien el request
                        _serverError.postValue(true)
                    }
                }

                override fun onFailure(call: Call<PokelistResponse>, t: Throwable) {
                    _isLoading.postValue(false)
                    _serverError.postValue(true)
                }

            })
    }
}