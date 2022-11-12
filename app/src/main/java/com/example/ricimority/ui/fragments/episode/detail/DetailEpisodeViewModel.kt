package com.example.ricimority.ui.fragments.episode.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.repositoryes.RepositoryEpisode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailEpisodeViewModel @Inject constructor(
    private val repositoryEpisode: RepositoryEpisode
) : ViewModel() {

    fun getEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return repositoryEpisode.getEpisode(id)
    }


}