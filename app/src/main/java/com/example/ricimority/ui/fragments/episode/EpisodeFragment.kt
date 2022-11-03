package com.example.ricimority.ui.fragments.episode


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.R
import com.example.ricimority.data.network.apiservices.checkingtheInternet.CheckingTheInternet
import com.example.ricimority.databinding.FragmentEpisodeBinding
import com.example.ricimority.ui.adapters.EpisodeAdapter

class EpisodeFragment
    : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter()

    override fun initialize() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObservers() {
        if (CheckingTheInternet.isOnline(requireContext())) {
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it.results)
            }
        }else {
            viewModel.getAllFromRoom().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it)
                Log.e("not internet", "is network")
            }
        }
    }
}