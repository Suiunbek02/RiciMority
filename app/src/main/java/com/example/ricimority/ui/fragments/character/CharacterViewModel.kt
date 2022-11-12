package com.example.ricimority.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.repositories.RepositoriCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val character: RepositoriCharacter
) : ViewModel() {

    fun fetchCharacters(): LiveData<PagingData<Charactermodel>> {
        return character.fetchCaracters().cachedIn(viewModelScope)
    }



}
