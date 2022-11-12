package com.example.ricimority.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ricimority.base.BaseDiffUtilltemCallback
import com.example.ricimority.databinding.ItemEpisodeBinding
import com.example.ricimority.model.episode.EpisodeModel

class EpisodeAdapter(
    private val onClick: OnClickList
) :
    PagingDataAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(BaseDiffUtilltemCallback()) {

    class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EpisodeModel?, onClick: OnClickList ) {
            binding.episodeName.text = item?.name
            binding.episodeAirDate.text = item?.type
            binding.episodeCharacters.text = item?.url
            binding.episodeCreated.text = item?.created
            itemView.setOnClickListener{
                onClick.listener(item)
            }
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
        holder.onBind(getItem(position), onClick)
    }
}

interface OnClickList{
    fun listener(model: EpisodeModel?)
}