package com.findapple.findapple.app.features.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.findapple.findapple.R
import com.findapple.findapple.app.features.chat.dialog.DatePickerDialog
import com.findapple.findapple.app.features.chat.dialog.TimePickerDialog
import com.findapple.findapple.app.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.databinding.FragmentChatDetailBinding

import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ChatDetailFragment : DaggerFragment() {

    lateinit var binding: FragmentChatDetailBinding

    @Inject
    lateinit var viewModel: ChattingViewModel

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
        binding.lifecycleOwner = viewLifecycleOwner

        val idArg by navArgs<ChatDetailFragmentArgs>()
        binding.url = "http://211.38.86.92:4046/chat?id=${idArg.chatRoomId}"

        requireActivity().onBackPressedDispatcher.addCallback {
            requireActivity().findNavController(R.id.main_activity_container).navigateUp()
        }
    }

    fun showDatePickerDialog() {
        DatePickerDialog(viewModel, this).show(
            requireActivity().supportFragmentManager,
            "datePickerDialog"
        )
    }

    fun showTimePickerDialog() {
        TimePickerDialog(viewModel).show(
            requireActivity().supportFragmentManager,
            "timePickerDialog"
        )
    }
}