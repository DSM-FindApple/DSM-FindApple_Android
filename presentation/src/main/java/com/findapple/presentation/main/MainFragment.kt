package com.findapple.presentation.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentMainBinding
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel
import com.findapple.presentation.main.viewmodel.MainViewModel
import com.findapple.presentation.main.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainBottomNv.setupWithNavController(
            Navigation.findNavController(
                requireActivity(),
                R.id.main_fragment_container
            )
        )
    }

    override fun observeEvent() {

    }

}