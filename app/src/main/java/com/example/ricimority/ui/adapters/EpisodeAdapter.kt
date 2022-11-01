package com.example.ricimority.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ricimority.databinding.ItemEpisodeBinding
import com.example.ricimority.model.episode.EpisodeModel

class EpisodeAdapter : ListAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(DiffUtil) {

    class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EpisodeModel?) {
            binding.episodeName.text = item?.name
            binding.episodeAirDate.text = item?.type
            binding.episodeCharacters.text = item?.url
            binding.episodeCreated.text = item?.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return  oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}