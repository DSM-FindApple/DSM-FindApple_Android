package com.findapple.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.findapple.presentation.BR
import com.findapple.presentation.R
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding>(private val layoutId: Int) : DaggerFragment() {
    lateinit var binding: T
    abstract val viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        observeLogin()
        observeEvent()
        requireActivity().onBackPressedDispatcher.addCallback {
            onBackPressed()
        }
        binding.setVariable(BR.vm, viewModel)
    }

    private fun observeLogin() {
        viewModel.needLogin.observe(viewLifecycleOwner, {
            requireActivity().findNavController(R.id.main_activity_container)
                .navigate(R.id.action_mainFragment_to_authFragment)
        })
    }

    open fun onBackPressed() {
        findNavController().navigateUp()
    }

    abstract fun observeEvent()
}