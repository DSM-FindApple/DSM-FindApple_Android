package com.findapple.presentation.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentMainBinding
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.main.viewmodel.MainViewModel
import com.findapple.presentation.main.viewmodel.MainViewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainBottomNv.setupWithNavController(
            Navigation.findNavController(
                requireActivity(),
                R.id.main_fragment_container
            )
        )
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener {

            }
        }
    }

    override fun observeEvent() {

    }

}