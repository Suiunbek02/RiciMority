package com.example.ricimority.ui.fragments.location.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.R
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.databinding.FragmentDetail3Binding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailLocationFragment :
    BaseFragment<FragmentDetail3Binding, DetailLocationViewModel>(R.layout.fragment_detail3) {

    override val binding by viewBinding(FragmentDetail3Binding :: bind)
    override val viewModel: DetailLocationViewModel by viewModels()
    private val safeArgs by navArgs<DetailLocationFragmentArgs>()

    override fun setupView(): Unit = with(binding) {
        lifecycleScope.launch {
            viewModel.getlocation(safeArgs.getId).observe(viewLifecycleOwner) {model ->
                binding.root
                binding.locationName.text = model.name
                binding.locationAirDate.text = model.url
                binding.locationCreated.text = model.created
            }
        }
    }
}