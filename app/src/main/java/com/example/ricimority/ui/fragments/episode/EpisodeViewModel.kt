package com.example.ricimority.ui.fragments.episode


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.repositories.RepositoryEpisode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episode: RepositoryEpisode
) : ViewModel() {

    fun fetchEpisode(): LiveData<PagingData<EpisodeModel>>{
        return episode.fetchEpisode().cachedIn(viewModelScope)
    }
}