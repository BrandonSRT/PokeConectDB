package com.example.pokeconectdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeconectdb.network.RetrofitProvider
import com.example.pokeconectdb.network.models.PokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentPokemonViewModel: ViewModel() {
    private val retrofitProvider = RetrofitProvider()

    private val _currentPokeLiveData = MutableLiveData<PokeResponse>()
    val currentPokeLiveData: LiveData<PokeResponse> = _currentPokeLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _serverError = MutableLiveData<Boolean>()
    val serverError: LiveData<Boolean> = _serverError

    fun fetchCurrentPokeData(name: String) {
        _isLoading.postValue(true)
        retrofitProvider.getApiService()
            .getCurrentPokemon(name)
            .enqueue(object : Callback<PokeResponse> {
                override fun onResponse(
                    call: Call<PokeResponse>,
                    response: Response<PokeResponse>
                ) {
                    _isLoading.postValue(false)
                    if (response.isSuccessful) {
                        _currentPokeLiveData.postValue(response.body())
                    } else {
                        // Servidor falla, por varias razones, por ejemplo, no se armo bien el request
                        _serverError.postValue(true)
                    }
                }

                override fun onFailure(call: Call<PokeResponse>, t: Throwable) {
                    _isLoading.postValue(false)
                    _serverError.postValue(true)
                }

            })
    }
}