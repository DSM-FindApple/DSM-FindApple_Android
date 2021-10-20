package com.findapple.presentation.features.find

import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.findapple.domain.entity.Location
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentFindBinding
import com.findapple.presentation.features.find.viewmodel.FindViewModel
import com.findapple.presentation.features.find.viewmodel.FindViewModelFactory
import com.findapple.presentation.main.viewmodel.MainViewModel
import com.google.android.gms.common.util.CollectionUtils
import javax.inject.Inject

class FindFragment : BaseFragment<FragmentFindBinding>(R.layout.fragment_find) {
    @Inject
    lateinit var viewModelFactory: FindViewModelFactory
    override val viewModel: FindViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(FindViewModel::class.java)
    }

    @Inject
    lateinit var mainViewModel: MainViewModel

    lateinit var geocoder: Geocoder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        geocoder = Geocoder(context)
    }

    override fun observeEvent() {
        mainViewModel.location.observe(viewLifecycleOwner, {
            setLocationText(it)
        })
        viewModel.startPostFind.observe(viewLifecycleOwner, {
            startPost()
        })
    }

    private fun startPost() {
        requireActivity().findNavController(R.id.main_activity_container)
            .navigate(R.id.action_mainFragment_to_postFindFragment)
    }

    private fun setLocationText(location: Location) {
        val address = geocoder.getFromLocation(location.latitude!!, location.longitude!!, 1)
        if (!CollectionUtils.isEmpty(address)) {
            val fetchAddress = address[0]
            if (fetchAddress.maxAddressLineIndex > -1) {
                viewModel.run {
                    cityName.value = fetchAddress.adminArea
                    townName.value = fetchAddress.thoroughfare
                }
            }
        }
    }
}