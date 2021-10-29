package com.findapple.findapple.presentation.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.presentation.R
import com.findapple.findapple.presentation.databinding.FragmentMainBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.main.viewmodel.MainViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    @Inject
    override lateinit var viewModel: MainViewModel

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
        checkLocation()
    }

    private fun checkLocation() {
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
                if(it!=null){
                    viewModel.location.value = Location(it.longitude, it.latitude)
                }
            }
        }
    }

    override fun observeEvent() {

    }

}