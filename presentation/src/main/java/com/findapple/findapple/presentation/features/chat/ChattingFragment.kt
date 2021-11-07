package com.findapple.findapple.presentation.features.chat

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentChattingBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.presentation.main.MainFragmentDirections
import javax.inject.Inject

class ChattingFragment : BaseFragment<FragmentChattingBinding>(R.layout.fragment_chatting) {
    @Inject
    override lateinit var viewModel: ChattingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chatWv.addJavascriptInterface(ChatWebBridge(this), "ChatDetail")
    }

    override fun observeEvent() {
    }

    fun moveToChattingDetail(id: String) {
        val action = MainFragmentDirections.actionMainFragmentToChatDetailFragment(id)
        findNavController().navigate(action)
    }
}