package com.findapple.findapple.app.features.chat.detail

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.findapple.findapple.app.main.viewmodel.MainViewModel
import com.findapple.findapple.databinding.FragmentChatDetailBinding
import javax.inject.Inject
import kotlin.properties.Delegates

class ChatDetailFragment : BaseFragment<FragmentChatDetailBinding>(R.layout.fragment_chat_detail) {
    @Inject
    override lateinit var viewModel: ChatDetailViewModel

    @Inject
    lateinit var mainViewModel: MainViewModel
    override fun observeEvent() {
    }

    var chatRoomId by Delegates.notNull<String>()
    var targetId by Delegates.notNull<Long>()
    var isBan = false
    var title = ""
    var topMessage = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.chatDetailWv.addJavascriptInterface(ChatWebBridge(this), "ChatDetail")

        val idArg by navArgs<ChatDetailFragmentArgs>()
        chatRoomId = idArg.chatRoomId
        isBan = idArg.isBan
        title = idArg.title
        topMessage = idArg.topMessage
        targetId = idArg.targetId
        refreshChatRoom()
    }

    private val chatDetailWebViewClient = object : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.chatDetailWv.loadUrl("javascript:sendToken(`${mainViewModel.token.value}`)")
            binding.chatDetailWv.loadUrl("javascript:chatInfo(`$chatRoomId`,$isBan,`$title`,`$topMessage`,$targetId)")
        }
    }

    fun refreshChatRoom() {
        binding.url =
            "http://www.findapple.app.s3-website.ap-northeast-2.amazonaws.com/chat?id=$chatRoomId"
        binding.chatDetailWv.webViewClient = chatDetailWebViewClient

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

    fun finishSelectDate(chatId: String, date: String, targetId: Long) {
        binding.url = "http://www.findapple.app.s3-website.ap-northeast-2.amazonaws.com/location"
        Handler(Looper.myLooper()!!).postDelayed({
            binding.chatDetailWv.loadUrl("javascript:sendToken(`${mainViewModel.token.value}`)")
            binding.chatDetailWv.loadUrl("javascript:promiseLocation(`$chatId`, `$date`, $targetId)")
        }, 500)
    }

    fun sendImage() {

    }
}