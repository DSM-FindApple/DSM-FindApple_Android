package com.findapple.presentation.features.find

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentFindBinding
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.base.WebViewFragment
import com.findapple.presentation.features.find.viewmodel.FindViewModel
import com.findapple.presentation.features.find.viewmodel.FindViewModelFactory
import com.findapple.presentation.main.viewmodel.MainViewModel
import javax.inject.Inject

class FindFragment : WebViewFragment<FragmentFindBinding>(R.layout.fragment_find) {
    @Inject
    lateinit var viewModelFactory: FindViewModelFactory
    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(FindViewModel::class.java)
    }

    @Inject
    lateinit var mainViewModel: MainViewModel

    override val webViewUrl = "https://find-apple-client.vercel.app"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWebView(binding.findWv)
    }

    override fun observeEvent() {
        mainViewModel
    }
}