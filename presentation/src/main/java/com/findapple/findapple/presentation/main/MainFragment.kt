package com.findapple.findapple.presentation.main

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

    companion object {
        private const val LOCATION_REQUEST_CODE = 1
    }

    private fun checkLocation() {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(requireActivity(), permissions, LOCATION_REQUEST_CODE)
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                if (it != null) {
                    viewModel.location.value = Location(it.longitude, it.latitude)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_REQUEST_CODE) {
            getLocation()
        }
    }

    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it != null) {
                viewModel.location.value = Location(it.longitude, it.latitude)
            }
        }
    }

    override fun observeEvent() {
        viewModel.message.observe(viewLifecycleOwner, {
            snackBarComment(it)
        })
    }

}