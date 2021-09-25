package com.findapple.presentation.main

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentMainBinding
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.base.BaseViewModel

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override val viewModel: BaseViewModel
        get() = TODO("Not yet implemented")

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