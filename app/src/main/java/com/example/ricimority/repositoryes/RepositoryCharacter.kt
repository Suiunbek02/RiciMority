package com.example.ricimority.repositoryes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.data.network.apiservices.CharacterApi
import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.repositoryes.pagingsources.CharacterPagingSources
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RepositoryCharacter @Inject constructor(
    private val characterApi: CharacterApi
) {

    fun fetchCaracters(): LiveData<PagingData<Charactermodel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSources(characterApi)
            }, initialKey = 1
        ).liveData
    }

    val data: MutableLiveData<Charactermodel> = MutableLiveData()

    fun getCharacter(id: Int): MutableLiveData<Charactermodel> {
        characterApi.getCharacter(id)
            .enqueue(object : Callback<Charactermodel> {
                override fun onResponse(
                    call: Call<Charactermodel>,
                    response: Response<Charactermodel>
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<Charactermodel>,
                    t: Throwable
                ) {

                }
            })
        return data
    }
}
