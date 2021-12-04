package com.findapple.findapple.app.features.chat.detail

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
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
        binding.url = "http://www.findapple.app.s3-website.ap-northeast-2.amazonaws.com/chat?id=$chatRoomId"
        val isBan = idArg.isBan
        val title = idArg.title
        val topMessage = idArg.topMessage
        val targetId = idArg.targetId
        binding.chatDetailWv.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.chatDetailWv.loadUrl("javascript:chatInfo(`$chatRoomId`,`$isBan`,`$title`,`$topMessage`,`$targetId`)")
            }
        }
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