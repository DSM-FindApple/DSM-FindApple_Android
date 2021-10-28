package com.findapple.presentation.features.chat

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentChattingBinding
import com.findapple.presentation.features.chat.viewmodel.ChattingViewModel
import com.findapple.presentation.features.chat.viewmodel.ChattingViewModelFactory
import javax.inject.Inject

class ChattingFragment : BaseFragment<FragmentChattingBinding>(R.layout.fragment_chatting) {
    @Inject
    lateinit var viewModelFactory: ChattingViewModelFactory
    override val viewModel: ChattingViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChattingViewModel::class.java)
    }

    override fun observeEvent() {

    }
}