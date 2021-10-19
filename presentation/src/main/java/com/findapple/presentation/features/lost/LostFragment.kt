package com.findapple.presentation.features.lost

import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.findapple.domain.entity.Location
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentLostBinding
import com.findapple.presentation.base.WebViewFragment
import com.findapple.presentation.features.lost.viewmodel.LostViewModel
import com.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
import com.findapple.presentation.main.viewmodel.MainViewModel
import com.google.android.gms.common.util.CollectionUtils
import javax.inject.Inject

class LostFragment : WebViewFragment<FragmentLostBinding>(R.layout.fragment_lost) {

    @Inject
    lateinit var viewModelFactory: LostViewModelFactory

    override val viewModel: LostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LostViewModel::class.java)
    }

    @Inject
    lateinit var mainViewModel: MainViewModel

    lateinit var geocoder: Geocoder

    override val webViewUrl = "https://find-apple-client.vercel.app"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWebView(binding.lostWv)
        geocoder = Geocoder(context)
    }

    override fun observeEvent() {
        mainViewModel.location.observe(viewLifecycleOwner, {
            setLocationText(it)
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


}