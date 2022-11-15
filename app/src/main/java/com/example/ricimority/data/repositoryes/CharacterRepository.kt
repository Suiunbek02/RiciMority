package com.example.ricimority.data.repositoryes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.data.network.apiservices.CharacterApi
import com.example.ricimority.data.repositoryes.pagingsources.CharacterPagingSources
import com.example.ricimority.model.character.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApi: CharacterApi
) {

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>> {
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

    val data: MutableLiveData<CharacterModel> = MutableLiveData()

    fun getCharacter(id: Int): MutableLiveData<CharacterModel> {
        characterApi.getCharacter(id)
            .enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<CharacterModel>,
                    t: Throwable
                ) {

                }
            })
        return data
    }
}
