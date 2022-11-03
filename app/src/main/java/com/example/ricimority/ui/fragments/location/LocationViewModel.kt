package com.example.ricimority.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.location.LocationModel
import com.example.ricimority.repositories.RepositoryLocation

class LocationViewModel: ViewModel() {

     private  val repository = RepositoryLocation()

     fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
         return repository.fetchLocation()
     }

    fun getAllFromRoom(): LiveData<List<LocationModel>> {
        return repository.getLocation()
    }
}