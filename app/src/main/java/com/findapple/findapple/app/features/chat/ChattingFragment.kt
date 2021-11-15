package com.findapple.findapple.app.features.chat

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentChattingBinding
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.app.main.MainFragmentDirections
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
        requireActivity().findNavController(R.id.main_activity_container).navigate(action)
    }
}