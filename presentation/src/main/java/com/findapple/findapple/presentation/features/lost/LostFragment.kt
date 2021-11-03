package com.findapple.findapple.presentation.features.lost

import android.location.Geocoder
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentLostBinding
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.features.lost.viewmodel.LostViewModel
import com.findapple.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
import com.findapple.findapple.presentation.main.viewmodel.MainViewModel
import com.google.android.gms.common.util.CollectionUtils
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import javax.inject.Inject

class LostFragment : BaseFragment<FragmentLostBinding>(R.layout.fragment_lost) {

    @Inject
    lateinit var viewModelFactory: LostViewModelFactory

    override val viewModel: LostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LostViewModel::class.java)
    }

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            lostSpl.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
            var touchStartY = 0
            lostList.setOnTouchListener { view, motionEvent ->
                if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                    touchStartY = motionEvent.y.toInt()
                }
                if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                    if (touchStartY < motionEvent.y.toInt()) {
                        lostSpl.panelState = SlidingUpPanelLayout.PanelState.HIDDEN
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
        viewModel.startPostLost.observe(viewLifecycleOwner, {
            startPost()
        })
    }

    private fun setLocationText(location: Location) {
        val geocoder = Geocoder(context)
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
        requireActivity().findNavController(R.id.main_activity_container)
            .navigate(R.id.action_mainFragment_to_postLostFragment)
        /*if (mainViewModel.hasLogin.value == true) {
            requireActivity().findNavController(R.id.main_activity_container)
                .navigate(R.id.action_mainFragment_to_postLostFragment)
        } else {
            viewModel.needLogin.call()
        }*/

    }


}