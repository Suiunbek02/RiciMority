package com.example.ricimority.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.ricimority.R
import com.example.ricimority.base.BaseFragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.databinding.FragmentDetail2Binding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailEpisodeFragment :
    BaseFragment<FragmentDetail2Binding, DetailEpisodeViewModel>(R.layout.fragment_detail2) {

     override val binding by viewBinding(FragmentDetail2Binding :: bind)
    override val viewModel: DetailEpisodeViewModel by viewModels()
    private val safeArgs by navArgs<DetailEpisodeFragmentArgs>()

    override fun setupView(): Unit = with(binding) {
        lifecycleScope.launch {
            viewModel.getEpisode(safeArgs.getid).observe(viewLifecycleOwner) {model ->
                binding.root
                binding.episodeCharacters.text = model.url
                binding.episodeCreated.text = model.created
                binding.episodeName.text = model.name
                binding.episodeAirDate.text = model.type
            }
        }
    }








}