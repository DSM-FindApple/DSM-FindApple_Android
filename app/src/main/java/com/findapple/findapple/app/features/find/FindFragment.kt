package com.findapple.findapple.app.features.find

import android.location.Geocoder
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentFindBinding
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.find.viewmodel.FindViewModel
import com.findapple.findapple.app.features.find.viewmodel.FindViewModelFactory
import com.findapple.findapple.app.main.MainFragmentDirections
import com.findapple.findapple.app.main.viewmodel.MainViewModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            findRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    findSpl.isTouchEnabled = !recyclerView.canScrollVertically(-1)
                    if (!recyclerView.canScrollVertically(1)) {
                        readNextPosts()
                    }
                }
            })
            findWv.addJavascriptInterface(FindWebBridge(this@FindFragment), "Find")
            findWv.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                        findWv.loadUrl("javascript:sendToken(`${mainViewModel.token.value}`)")
                }
            }
        }
    }

    private fun readNextPosts() {
        viewModel.run {
            page.value = viewModel.page.value!! + 1
            getPosts()
        }
    }

    private fun setLocation(location: Location) {
        viewModel.location = location
        setLocationText(viewModel.location)
    }

    override fun observeEvent() {
        viewModel.startPostFind.observe(viewLifecycleOwner, {
            startPost()
        })
        mainViewModel.location.observe(viewLifecycleOwner, {
            setLocation(it)
            viewModel.getPosts()
        })
    }

    private fun setLocationText(location: Location) {
        val geocoder = Geocoder(context)
        val address = geocoder.getFromLocation(location.latitude, location.longitude, 1)
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
            moveFragmentByActionId(R.id.action_mainFragment_to_postFindFragment)
        } else {
            viewModel.needLogin.call()
        }

    }

    fun moveToSearch(type: String) {
        val action = MainFragmentDirections.actionMainFragmentToSearchFragment(type)
        requireActivity().findNavController(R.id.main_activity_container).navigate(action)
    }
}