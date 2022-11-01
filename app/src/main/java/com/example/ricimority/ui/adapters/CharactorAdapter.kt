package com.example.ricimority.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ricimority.base.BaseDiffUtilltemCallback
import com.example.ricimority.databinding.ItemCharacterBinding
import com.example.ricimority.model.character.Charactermodel

class CharactorAdapter :
    ListAdapter<Charactermodel, CharactorAdapter.ViewHolder>(BaseDiffUtilltemCallback()) {

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Charactermodel?) {
            binding.itemCharacterText.text = item?.name
            binding.itemCharacterImage.load(item?.image)
            binding.itemCharacterStatus.text = item?.status
            binding.itemFirstSeenIn.text = item?.created
            binding.itemImageRound.setCardBackgroundColor(colorImage(item))
        }

        private fun colorImage(item: Charactermodel?): Int {
            return when (item?.status) {
                "Alive" -> {
                    Color.parseColor("#1e9e05")
                }
                "Dead" -> {
                    Color.parseColor("#FF0000")
                }
                else -> {
                    Color.parseColor("#1e9e05")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
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
