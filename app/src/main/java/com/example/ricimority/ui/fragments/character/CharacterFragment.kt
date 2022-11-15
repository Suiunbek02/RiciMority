package com.example.ricimority.ui.fragments.character


import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.R
import com.example.ricimority.data.network.apiservices.checkingtheInternet.CheckingTheInternet
import com.example.ricimority.databinding.FragmentCharacterBinding
import com.example.ricimority.model.character.CharacterModel
import com.example.ricimority.ui.adapters.CharacterAdapter
import com.example.ricimority.ui.adapters.OnClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character),
    OnClick {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter(this)

    override fun initialize() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObservers() {
        if (CheckingTheInternet.isOnline(requireContext())) {
            viewModel.fetchCharacters().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    characterAdapter.submitData(it)
                }
            }
        }
    }

    override fun setupView() {
        binding.characterProgressBar.visibility = View.GONE
    }

    override fun listener(model: CharacterModel?) {
        findNavController().navigate(
            CharacterFragmentDirections
                .actionCharacterFragmentToDetailCharacterFragment(model?.id!!)
        )
    }
}


