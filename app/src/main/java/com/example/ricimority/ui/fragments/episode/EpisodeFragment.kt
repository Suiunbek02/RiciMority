package com.example.ricimority.ui.fragments.episode


import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.R
import com.example.ricimority.data.network.apiservices.checkingtheInternet.CheckingTheInternet
import com.example.ricimority.databinding.FragmentEpisodeBinding
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.ui.adapters.EpisodeAdapter
import com.example.ricimority.ui.adapters.OnClickList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeFragment
    : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode),
OnClickList{

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter(this)

    override fun initialize() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObservers() {
        if (CheckingTheInternet.isOnline(requireContext())) {
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                lifecycleScope.launch{
                    episodeAdapter.submitData(it)
                }
            }
        }
    }

    override fun setupView() {
        binding.episodeProgressBar.visibility = View.GONE
    }

    override fun listener(model: EpisodeModel?) {
        findNavController().navigate(
            EpisodeFragmentDirections
                .actionEpisodeFragmentToDetailEpisodeFragment(model?.id!!)
        )
    }
}