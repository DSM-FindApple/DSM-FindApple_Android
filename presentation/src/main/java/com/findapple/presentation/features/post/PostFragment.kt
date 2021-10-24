package com.findapple.presentation.features.post

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.findapple.presentation.R
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.databinding.FragmentPostBinding
import com.findapple.presentation.features.post.adapter.CategoryAdapter
import com.findapple.presentation.features.post.viewModel.PostViewModel
import com.findapple.presentation.features.post.viewModel.PostViewModelFactory
import javax.inject.Inject

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    @Inject
    lateinit var viewModelFactory: PostViewModelFactory

    override val viewModel: PostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
    }

    private val categoryAdapter by lazy {
        CategoryAdapter(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            postTb.setNavigationOnClickListener {
                onBackPressed()
            }

            postCategoryRv.run {
                val layoutManager = LinearLayoutManager(requireContext()).apply {
                    orientation = LinearLayoutManager.HORIZONTAL
                }
                adapter = categoryAdapter
                setLayoutManager(layoutManager)
            }
            isLost = (arguments?.get("isLost") ?: true) as Boolean?
        }
    }

    override fun observeEvent() {
        viewModel.run {
            clickedCategoryIndex.observe(viewLifecycleOwner, {
                if (preClickedCategoryIndex.value == null) { // when first clicked
                    preClickedCategoryIndex.value = it
                }
                if (preClickedCategoryIndex.value != null) {
                    categoryAdapter.notifyItemChanged(preClickedCategoryIndex.value!!, Unit)
                }
                if (it != null) {
                    categoryAdapter.notifyItemChanged(it, Unit)
                    preClickedCategoryIndex.value = it
                }
            })

            startCamera.observe(viewLifecycleOwner, {
                this@PostFragment.startCamera()
            })
            startGallery.observe(viewLifecycleOwner, {
                this@PostFragment.startGallery()
            })
        }
    }

    private fun startCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            startActivityForResult(takePictureIntent, 2)
        }
    }

    private fun startGallery() {
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).also {
            startActivityForResult(it, 3)
        }
    }

}