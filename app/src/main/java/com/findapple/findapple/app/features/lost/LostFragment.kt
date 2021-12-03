package com.findapple.findapple.app.features.lost

import android.location.Geocoder
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentLostBinding
import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.lost.viewmodel.LostViewModel
import com.findapple.findapple.app.features.lost.viewmodel.LostViewModelFactory
import com.findapple.findapple.app.features.post.MorePostDialog
import com.findapple.findapple.app.main.MainFragmentDirections
import com.findapple.findapple.app.main.viewmodel.MainViewModel
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
            lostList.setOnTouchListener { _, motionEvent ->
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
            lostRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    lostSpl.isTouchEnabled = !recyclerView.canScrollVertically(-1)
                    if (!recyclerView.canScrollVertically(1)) {
                        readNextPosts()
                    }
                }
            })
            lostWv.addJavascriptInterface(LostWebBridge(this@LostFragment), "Lost")
            lostWv.loadUrl("javascript:sendToken(`${mainViewModel.token.value}`)")
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
        viewModel.run {
            startPostLost.observe(viewLifecycleOwner, {
                this@LostFragment.startPost()
            })
            clickedCommentId.observe(viewLifecycleOwner, {
                this@LostFragment.startComment(it)
            })
            moreClickedPostId.observe(viewLifecycleOwner, {
                MorePostDialog(viewModel, it).show(
                    requireActivity().supportFragmentManager,
                    "morePostDialog"
                )
            })
        }
        mainViewModel.location.observe(viewLifecycleOwner, {
            setLocation(it)
            viewModel.getPosts()
        })
    }

    private fun startComment(id: Long) {
        val action = MainFragmentDirections.actionMainFragmentToCommentFragment(id, true)
        requireActivity().findNavController(R.id.main_activity_container).navigate(action)
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
            moveFragmentByActionId(R.id.action_mainFragment_to_postLostFragment)
        } else {
            viewModel.needLogin.call()
        }

    }


}