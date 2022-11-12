package com.example.ricimority.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ricimority.model.location.LocationModel
import com.example.ricimority.repositoryes.RepositoryLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val location: RepositoryLocation
) : ViewModel() {

    fun fetchLocation(): LiveData<PagingData<LocationModel>> {
        return location.fetchLocation().cachedIn(viewModelScope)
    }
}