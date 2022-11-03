package com.example.ricimority.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ricimority.base.BaseDiffUtilltemCallback
import com.example.ricimority.base.IBaseDiffUtill
import com.example.ricimority.databinding.ItemLocationBinding
import com.example.ricimority.model.location.LocationModel

class LocationAdapter :
    ListAdapter<LocationModel, LocationAdapter.ViewHolder>(BaseDiffUtilltemCallback()) {

    class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: LocationModel?) {
            binding.locationName.text = item?.name
            binding.locationDimension.text = item?.created
            binding.locationText.text = item?.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}