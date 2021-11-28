package com.findapple.findapple.app.features.comment.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.comment.viewmodel.CommentViewModel
import com.findapple.findapple.app.features.comment.viewmodel.CommentViewModelFactory
import com.findapple.findapple.databinding.FragmentCommentBinding
import javax.inject.Inject

class CommentFragment : BaseFragment<FragmentCommentBinding>(R.layout.fragment_comment) {

    @Inject
    lateinit var viewModelFactory: CommentViewModelFactory

    override val viewModel: CommentViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(CommentViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val idArgs by navArgs<CommentFragmentArgs>()
        viewModel.postId = idArgs.postId
        viewModel.isLost = idArgs.isLost
        super.onViewCreated(view, savedInstanceState)
        binding.commentTb.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun observeEvent() {

    }

}