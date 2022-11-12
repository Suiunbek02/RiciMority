package com.example.ricimority.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.App
import com.example.ricimority.data.network.apiservices.CharactorApi
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.repositories.pagingsources.CharacterPagingSources
import kotlinx.coroutines.flow.flow
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RepositoriCharacter @Inject constructor(
    private val charactorApi: CharactorApi
) {

    fun fetchCaracters(): LiveData<PagingData<Charactermodel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSources(charactorApi)
            }, initialKey = 1
        ).liveData
    }

    val data: MutableLiveData<Charactermodel> = MutableLiveData()

    fun getCharacter(id: Int): MutableLiveData<Charactermodel> {
        charactorApi.getCharacter(id)
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
