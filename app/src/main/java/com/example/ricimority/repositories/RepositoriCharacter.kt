package com.example.ricimority.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ricimority.App
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.character.Charactermodel
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class RepositoriCharacter {
    val data: MutableLiveData<RickAndMortyResponse<Charactermodel>> = MutableLiveData()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<Charactermodel>> {
        App.charactorApi?.fetchCharacters()
            ?.enqueue(object : Callback<RickAndMortyResponse<Charactermodel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<Charactermodel>>,
                    response: Response<RickAndMortyResponse<Charactermodel>>
                ) {
                    response.body()?.let {
                        App.appDatabase?.characterDao()?.insertList(it.results) }
                        data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<Charactermodel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getCharacters(): LiveData<List<Charactermodel>> {
        return App.appDatabase?.characterDao()?.getAllList()!!
    }
}
