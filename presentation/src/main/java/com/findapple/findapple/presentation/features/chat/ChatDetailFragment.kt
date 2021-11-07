package com.findapple.findapple.presentation.features.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentChatDetailBinding
import com.findapple.findapple.databinding.FragmentChattingBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ChatDetailFragment : DaggerFragment() {

    lateinit var binding: FragmentChatDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idArg by navArgs<ChatDetailFragmentArgs>()
        binding.url = "http://211.38.86.92:4046/chat/${idArg.chatRoomId}"

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigateUp()
        }
    }
}