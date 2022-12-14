package com.example.ricimority.ui.fragments.location.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricimority.model.location.LocationModel
import com.example.ricimority.data.repositoryes.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailLocationViewModel @Inject constructor(
    private val repositoryLocation: LocationRepository
) : ViewModel() {

    fun fetchLocation(id: Int): MutableLiveData<LocationModel> {
        return repositoryLocation.fetchDetailLocation(id)
    }
}