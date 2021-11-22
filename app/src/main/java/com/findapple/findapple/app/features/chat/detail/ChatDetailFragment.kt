package com.findapple.findapple.app.features.chat.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.chat.ChatWebBridge
import com.findapple.findapple.app.features.chat.detail.viewmodel.ChatDetailViewModel
import com.findapple.findapple.app.features.chat.dialog.DatePickerDialog
import com.findapple.findapple.app.features.chat.dialog.TimePickerDialog
import com.findapple.findapple.databinding.FragmentChatDetailBinding
import javax.inject.Inject

class ChatDetailFragment : BaseFragment<FragmentChatDetailBinding>(R.layout.fragment_chat_detail) {
    @Inject
    override lateinit var viewModel: ChatDetailViewModel
    override fun observeEvent() {
    }

    private lateinit var chatRoomId: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.chatDetailWv.addJavascriptInterface(ChatWebBridge(this), "ChatDetail")

        val idArg by navArgs<ChatDetailFragmentArgs>()
        chatRoomId = idArg.chatRoomId
        binding.url = "http://211.38.86.92:4046/chat?id=$chatRoomId"

    }

    fun showDatePickerDialog() {
        DatePickerDialog(viewModel, this).show(
            requireActivity().supportFragmentManager,
            "datePickerDialog"
        )
    }

    fun showTimePickerDialog() {
        TimePickerDialog(viewModel, this).show(
            requireActivity().supportFragmentManager,
            "timePickerDialog"
        )
    }

    fun finishSelectDate() {
        val method = "LocationChoice(\"${viewModel.selectedDateTime.value}\",\"$chatRoomId\")"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            binding.chatDetailWv.evaluateJavascript(method, null)
        } else {
            binding.chatDetailWv.loadUrl("javascript:$method")
        }
    }

    fun sendImage() {

    }
}