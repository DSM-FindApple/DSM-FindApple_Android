package com.findapple.findapple.app.features.chat

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.findNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentChattingBinding
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.app.main.MainFragmentDirections
import com.findapple.findapple.app.main.viewmodel.MainViewModel
import javax.inject.Inject

class ChattingFragment : BaseFragment<FragmentChattingBinding>(R.layout.fragment_chatting) {
    @Inject
    override lateinit var viewModel: ChattingViewModel

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webBridge = ChatWebBridge(this)
        binding.chatWv.addJavascriptInterface(webBridge, "ChatDetail")
        binding.chatWv.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webBridge.sendToken(mainViewModel.token.value?:"")
            }
        }

    }

    override fun observeEvent() {
    }

    fun moveToChattingDetail(id: String, isBan: Boolean, title: String, topMessage: String, targetId: Long) {
        val action = MainFragmentDirections.actionMainFragmentToChatDetailFragment(id, isBan, title, topMessage, targetId)
        requireActivity().findNavController(R.id.main_activity_container).navigate(action)
    }
}