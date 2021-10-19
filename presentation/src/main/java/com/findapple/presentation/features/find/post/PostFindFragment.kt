package com.findapple.presentation.features.find.post

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentPostFindBinding
import com.findapple.presentation.features.find.post.viewModel.PostFindViewModel

class PostFindFragment : BaseFragment<FragmentPostFindBinding>(R.layout.fragment_post_find) {

    override val viewModel: PostFindViewModel by lazy {
        ViewModelProvider(this).get(PostFindViewModel::class.java)
    }

    override fun observeEvent() {
    }
}