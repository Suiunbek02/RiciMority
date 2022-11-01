package com.example.ricimority.ui.fragments.charactor

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.R
import com.example.ricimority.databinding.FragmentCharacterBinding
import com.example.ricimority.ui.adapters.CharactorAdapter

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharactorViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharactorViewModel by viewModels()
    private val charactorAdapter = CharactorAdapter()

    override fun initialize() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactorAdapter
        }
    }

    override fun setupObservers() {
        if (isNetworkAvailable(requireContext())) {
            viewModel.fetchCharacter().observe(viewLifecycleOwner) {
                charactorAdapter.submitList(it.results)
            }
        }else {
            viewModel.getAllFromRoom().observe(viewLifecycleOwner) {
                charactorAdapter.submitList(it)
                Log.e("not internet", "is network")
            }
        }
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}