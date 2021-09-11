package com.findapple.findapple.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentMainBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.base.BaseViewModel

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

}