package com.example.ricimority.ui.fragments.location

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ricimority.R
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.data.network.apiservices.checkingtheInternet.CheckingTheInternet
import com.example.ricimority.databinding.FragmentLocationBinding
import com.example.ricimority.ui.adapters.LocationAdapter

class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter()

    override fun initialize() {
        binding.locationRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObservers() {
        if (CheckingTheInternet.isOnline(requireContext())) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it.results)
            }
        }else {
            viewModel.getAllFromRoom().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it)
                Log.e("not internet", "is network")
            }
        }
    }
}

