package com.findapple.presentation.features.auth

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.base.BackPressFinishFragment
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.databinding.FragmentAuthBinding
import com.findapple.presentation.features.auth.viewmodel.AuthViewModel
import com.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
import javax.inject.Inject

class AuthFragment : BackPressFinishFragment<FragmentAuthBinding>(R.layout.fragment_auth) {

    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory
    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
    }

    override fun observeEvent() {
    }

}