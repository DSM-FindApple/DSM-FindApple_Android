package com.findapple.presentation.features.auth

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.findapple.presentation.R
import com.findapple.presentation.base.BackPressFinishFragment
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.databinding.FragmentAuthBinding
import com.findapple.presentation.features.auth.viewmodel.AuthViewModel
import com.findapple.presentation.features.auth.viewmodel.AuthViewModelFactory
import javax.inject.Inject

class AuthFragment : BaseFragment<FragmentAuthBinding>(R.layout.fragment_auth) {

    @Inject
    lateinit var viewModelFactory: AuthViewModelFactory
    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        requireActivity().findNavController(R.id.main_fragment_container)
            .navigate(R.id.action_mypageFragment_to_lost_fragment)
    }

    override fun observeEvent() {
    }

}