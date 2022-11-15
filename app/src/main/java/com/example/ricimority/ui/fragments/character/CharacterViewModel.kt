package com.example.ricimority.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ricimority.model.character.CharacterModel
import com.example.ricimority.data.repositoryes.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val character: CharacterRepository
) : ViewModel() {

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>> {
        return character.fetchCharacters().cachedIn(viewModelScope)
    }
}
