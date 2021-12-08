package com.findapple.findapple.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.findapple.findapple.BR
import com.findapple.findapple.R
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    DaggerFragment() {
    lateinit var binding: T
    abstract val viewModel: BaseViewModel

    private val lifeCycleOwner by lazy {
        LifeCycleOwner(viewModel)
    }

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
        notifyEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun onStart() {
        super.onStart()
        notifyEvent(Lifecycle.Event.ON_START)
    }

    override fun onResume() {
        super.onResume()
        notifyEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onPause() {
        notifyEvent(Lifecycle.Event.ON_PAUSE)
        super.onPause()
    }

    override fun onStop() {
        notifyEvent(Lifecycle.Event.ON_STOP)
        super.onStop()
    }

    override fun onDestroy() {
        notifyEvent(Lifecycle.Event.ON_DESTROY)
        super.onDestroy()
    }

    private fun observeLogin() {
        viewModel.needLogin.observe(viewLifecycleOwner, {
            moveFragmentByActionId(R.id.action_mainFragment_to_authFragment)
        })
    }

    open fun onBackPressed() {
        requireActivity().findNavController(R.id.main_activity_container).popBackStack()
    }

    fun moveFragmentByActionId(@IdRes actionId: Int) {
        requireActivity().findNavController(R.id.main_activity_container)
            .navigate(actionId)
    }

    abstract fun observeEvent()

    private fun notifyEvent(event: Lifecycle.Event) {
        lifeCycleOwner.notifyEvent(event)
    }

    fun snackBarComment(comment: String) {
        Snackbar.make(binding.root, comment, Snackbar.LENGTH_SHORT).show()
    }
}