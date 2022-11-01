package com.example.ricimority.ui.fragments.charactor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.repositories.RepositoriCharacter

class CharactorViewModel : ViewModel() {

    private val repositoryCharacter = RepositoriCharacter()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<Charactermodel>> {
        return  repositoryCharacter.fetchCharacter()
    }

    fun getAllFromRoom(): LiveData<List<Charactermodel>> {
        return repositoryCharacter.getCharacters()
    }
}