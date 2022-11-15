package com.example.ricimority.ui.fragments.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.ricimority.model.character.CharacterModel
import com.example.ricimority.data.repositoryes.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailCharacterViewModel @Inject constructor(
    private val repositoryCharacter: CharacterRepository
) : ViewModel() {

    fun fetchCharacter(id: Int): MutableLiveData<CharacterModel> {
        return repositoryCharacter.getCharacter(id)
    }
}
