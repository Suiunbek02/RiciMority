package com.example.ricimority.ui.fragments.episode.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricimority.App
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.repositories.RepositoryEpisode
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailEpisodeViewModel @Inject constructor(
    private val repositoryEpisode: RepositoryEpisode
) : ViewModel() {

    fun getEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return repositoryEpisode.getEpisode(id)
    }


}