package com.example.ricimority.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.ricimority.data.network.apiservices.LocationApi
import com.example.ricimority.model.location.LocationModel
import retrofit2.HttpException
import java.io.IOException

class LocationPagingSources (
    private val locationApi: LocationApi
    ) : PagingSource<Int, LocationModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        val position = params.key ?: 1

        return try {

            val response = locationApi.fetchLocation(position)
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

    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }
    }
}