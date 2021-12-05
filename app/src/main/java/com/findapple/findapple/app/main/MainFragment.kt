package com.findapple.findapple.app.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentMainBinding
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.main.viewmodel.MainViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    @Inject
    override lateinit var viewModel: MainViewModel


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
        viewModel.message.observe(viewLifecycleOwner, {
            snackBarComment(it)
        })
    }

}