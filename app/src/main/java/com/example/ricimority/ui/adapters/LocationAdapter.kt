package com.example.ricimority.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ricimority.base.BaseDiffUtilItemCallback
import com.example.ricimority.databinding.ItemLocationBinding
import com.example.ricimority.model.location.LocationModel

class LocationAdapter(
    private val shortClick: setShortClick
) :
    PagingDataAdapter<LocationModel, LocationAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: LocationModel?, shortClick: setShortClick) {
            binding.locationName.text = item?.name
            binding.locationDimension.text = item?.created
            binding.locationText.text = item?.url
            itemView.setOnClickListener {
                shortClick.listener(item)
            }
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
        holder.onBind(getItem(position), shortClick)
    }
}

interface setShortClick {
    fun listener(model: LocationModel?)
}