package com.findapple.findapple.presentation.features.find

import android.location.Geocoder
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentFindBinding
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.features.find.viewmodel.FindViewModel
import com.findapple.findapple.presentation.features.find.viewmodel.FindViewModelFactory
import com.findapple.findapple.presentation.main.viewmodel.MainViewModel
import com.google.android.gms.common.util.CollectionUtils
import com.sothree.slidinguppanel.SlidingUpPanelLayout
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
        binding.run {
            findSpl.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
            var touchStartY = 0
            findList.setOnTouchListener { _, motionEvent ->
                if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                    touchStartY = motionEvent.y.toInt()
                }
                if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                    if (touchStartY < motionEvent.y.toInt()) {
                        findSpl.panelState = SlidingUpPanelLayout.PanelState.HIDDEN
                    }
                }
                true
            }
        }
    }

    override fun observeEvent() {
        mainViewModel.location.observe(viewLifecycleOwner, {
            setLocationText(it)
        })
        viewModel.startPostFind.observe(viewLifecycleOwner, {
            startPost()
        })
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

    private fun startPost() {
        if (mainViewModel.hasLogin.value == true) {
            moveFragmentByActionId(R.id.action_mainFragment_to_postLostFragment)
        } else {
            viewModel.needLogin.call()
        }

    }
}