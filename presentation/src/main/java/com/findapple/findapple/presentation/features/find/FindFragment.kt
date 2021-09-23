package com.findapple.findapple.presentation.features.find

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentFindBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.base.BaseViewModel
import com.findapple.findapple.presentation.features.find.viewmodel.FindViewModel
import com.findapple.findapple.presentation.features.find.viewmodel.FindViewModelFactory
import javax.inject.Inject

class FindFragment : BaseFragment<FragmentFindBinding>(R.layout.fragment_find) {
    @Inject
    lateinit var viewModelFactory: FindViewModelFactory
    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(FindViewModel::class.java)
    }

    override fun observeEvent() {
    }
}