package com.findapple.presentation.features.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentSplashBinding
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {
    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
    }

    override fun observeEvent() {
    }
}