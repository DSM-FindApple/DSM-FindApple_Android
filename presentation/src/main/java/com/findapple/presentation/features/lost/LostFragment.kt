package com.findapple.presentation.features.lost

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentLostBinding
import com.findapple.presentation.base.BackPressFinishFragment
import com.findapple.presentation.features.lost.viewmodel.LostViewModel
import com.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
import javax.inject.Inject

class LostFragment : BackPressFinishFragment<FragmentLostBinding>(R.layout.fragment_lost) {

    @Inject
    lateinit var viewModelFactory: LostViewModelFactory

    override val viewModel: LostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LostViewModel::class.java)
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }


}