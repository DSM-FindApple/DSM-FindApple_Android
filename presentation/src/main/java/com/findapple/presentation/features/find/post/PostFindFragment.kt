package com.findapple.presentation.features.find.post

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentPostFindBinding
import com.findapple.presentation.features.find.post.viewModel.PostFindViewModel
import com.findapple.presentation.features.find.post.viewModel.PostFindViewModelFactory
import javax.inject.Inject

class PostFindFragment : BaseFragment<FragmentPostFindBinding>(R.layout.fragment_post_find) {

    @Inject
    lateinit var viewModelFactory: PostFindViewModelFactory

    override val viewModel: PostFindViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PostFindViewModel::class.java)
    }

    override fun observeEvent() {
    }
}