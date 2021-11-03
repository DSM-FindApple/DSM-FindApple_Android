package com.findapple.findapple.presentation.features.chat

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentChattingBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModelFactory
import javax.inject.Inject

class ChattingFragment : BaseFragment<FragmentChattingBinding>(R.layout.fragment_chatting) {
    @Inject
    lateinit var viewModelFactory: ChattingViewModelFactory
    override val viewModel: ChattingViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChattingViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chatWv.addJavascriptInterface(ChatWebBridge(), "CHAT_DETAIL")
    }

    override fun observeEvent() {

    }
}