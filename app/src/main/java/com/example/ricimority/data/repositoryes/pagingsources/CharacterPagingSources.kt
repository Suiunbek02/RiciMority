package com.example.ricimority.data.repositoryes.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.ricimority.data.network.apiservices.CharacterApi
import com.example.ricimority.model.character.CharacterModel
import retrofit2.HttpException
import java.io.IOException

class CharacterPagingSources(
    private val characterApi: CharacterApi): PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, CharacterModel> {
        val position = params.key ?: 1

        return try {

            val response = characterApi.fetchCharacters(position)
            val nextPage = response.info.next
            val nextPageNumber = if (nextPage == null) {

                null
            }else {
                Uri.parse(response.info.next).getQueryParameter("page")?.toInt()
            }

            PagingSource.LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPageNumber
            )

        }catch (exception: IOException) {
         return PagingSource.LoadResult.Error(exception)
        }catch (exception: HttpException) {
            return PagingSource.LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }
    }
}