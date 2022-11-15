package com.example.ricimority.ui.fragments.location

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.R
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.data.network.apiservices.checkingtheInternet.CheckingTheInternet
import com.example.ricimority.databinding.FragmentLocationBinding
import com.example.ricimority.model.location.LocationModel
import com.example.ricimority.ui.adapters.LocationAdapter
import com.example.ricimority.ui.adapters.setShortClick
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location),
    setShortClick {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter(this)

    override fun initialize() {
        binding.locationRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObservers() {
        if (CheckingTheInternet.isOnline(requireContext())) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    locationAdapter.submitData(it)
                }
            }
        }
    }

    override fun listener(model: LocationModel?) {
        findNavController().navigate(
            LocationFragmentDirections.
            actionLocationFragmentToDetailLocationFragment(model?.id!!)
        )
    }
}

