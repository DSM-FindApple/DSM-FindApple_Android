package com.findapple.presentation.features.post

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentPostBinding
import com.findapple.presentation.features.post.viewModel.PostViewModel
import com.findapple.presentation.features.post.viewModel.PostViewModelFactory
import javax.inject.Inject

class PostFindFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    @Inject
    lateinit var viewModelFactory: PostViewModelFactory

    override val viewModel: PostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postFindTb.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.postFindCategoryRv.run {
            val layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            adapter = CategoryAdapter(viewModel)
            setLayoutManager(layoutManager)
        }
    }

    override fun observeEvent() {
    }
}