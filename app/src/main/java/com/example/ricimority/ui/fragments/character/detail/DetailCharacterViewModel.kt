package com.example.ricimority.ui.fragments.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.repositoryes.RepositoryCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailCharacterViewModel @Inject constructor(
    private val repositoriCharacter: RepositoryCharacter
) : ViewModel() {

    fun getCharacter(id: Int): MutableLiveData<Charactermodel> {
        return repositoriCharacter.getCharacter(id)
    }
}
