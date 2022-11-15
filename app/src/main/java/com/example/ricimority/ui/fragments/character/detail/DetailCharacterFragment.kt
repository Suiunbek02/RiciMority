package com.example.ricimority.ui.fragments.character.detail


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.ricimority.R
import com.example.ricimority.base.BaseFragment
import com.example.ricimority.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailCharacterFragment :
    BaseFragment<FragmentDetailBinding, DetailCharacterViewModel> (R.layout.fragment_detail) {

    override val binding by viewBinding(FragmentDetailBinding :: bind)
    override val viewModel: DetailCharacterViewModel by viewModels()
    private val safeArgs by navArgs<DetailCharacterFragmentArgs>()

    override fun setupView(): Unit = with(binding) {
        lifecycleScope.launch {
            viewModel.fetchCharacter(safeArgs.id).observe(viewLifecycleOwner) { model ->
                binding.itemDetailImage.load(model.image)
                binding.itemDetailText.text = model.name
            }
        }
    }
}
