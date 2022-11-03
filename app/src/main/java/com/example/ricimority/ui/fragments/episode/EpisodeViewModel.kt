package com.example.ricimority.ui.fragments.episode


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.repositories.RepositoryEpisode

class EpisodeViewModel : ViewModel() {

    private val repository = RepositoryEpisode()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        return repository.fetchEpisode()
    }

    fun getAllFromRoom(): LiveData<List<EpisodeModel>> {
        return repository.getEpisodes()
    }
}