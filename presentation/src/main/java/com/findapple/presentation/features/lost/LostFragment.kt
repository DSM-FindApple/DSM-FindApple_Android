package com.findapple.presentation.features.lost

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentLostBinding
import com.findapple.presentation.base.BackPressFinishFragment
import com.findapple.presentation.base.WebViewFragment
import com.findapple.presentation.features.lost.viewmodel.LostViewModel
import com.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
import javax.inject.Inject

class LostFragment : WebViewFragment<FragmentLostBinding>(R.layout.fragment_lost) {

    @Inject
    lateinit var viewModelFactory: LostViewModelFactory

    override val viewModel: LostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LostViewModel::class.java)
    }

    override val webViewUrl = "https://find-apple-client.vercel.app"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWebView(binding.lostWv)
    }

    override fun observeEvent() {
    }


}