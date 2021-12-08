package com.findapple.findapple.app.features.mypage

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentMypageBinding
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.mypage.viewmodel.MyPageViewModel
import com.findapple.findapple.app.features.mypage.viewmodel.MyPageViewModelFactory
import com.findapple.findapple.app.features.post.MorePostDialog
import com.findapple.findapple.app.main.MainFragmentDirections
import com.findapple.findapple.domain.features.post.entity.Post
import javax.inject.Inject

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    @Inject
    lateinit var viewModelFactory: MyPageViewModelFactory

    override val viewModel: MyPageViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MyPageViewModel::class.java)
    }

    override fun observeEvent() {
        viewModel.run {
            showFindAppleLevelDetail.observe(viewLifecycleOwner, {
                FindAppleLevelDialog().show(
                    requireActivity().supportFragmentManager,
                    "findapple_level_detail"
                )
            })
            message.observe(viewLifecycleOwner, {
                snackBarComment(it)
            })
            moreClickedPostId.observe(viewLifecycleOwner, {
                MorePostDialog(viewModel, it).show(
                    requireActivity().supportFragmentManager,
                    "morePostDialog"
                )
            })
            editPost.observe(viewLifecycleOwner, {
                startEditPost(it)
            })
        }
    }

    private fun startEditPost(post: Post) {
        val action = MainFragmentDirections.actionMainFragmentToEditPostFragment(post.isLost, post.title, post.category, post.detailInfo)
        findNavController().navigate(action)
    }

}