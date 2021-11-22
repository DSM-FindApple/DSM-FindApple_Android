package com.findapple.findapple.app.features.post

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentPostBinding
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.post.adapter.CategoryAdapter
import com.findapple.findapple.app.features.post.viewModel.PostViewModel
import com.findapple.findapple.app.features.post.viewModel.PostViewModelFactory
import com.findapple.findapple.app.main.viewmodel.MainViewModel
import com.findapple.findapple.app.toUri
import javax.inject.Inject

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    @Inject
    lateinit var viewModelFactory: PostViewModelFactory

    override val viewModel: PostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
    }

    @Inject
    lateinit var mainViewModel: MainViewModel

    private val categoryAdapter by lazy {
        CategoryAdapter(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.location.value = mainViewModel.location.value
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

            message.observe(viewLifecycleOwner, {
                snackBarComment(it)
            })

            donePost.observe(viewLifecycleOwner, {
                onBackPressed()
            })

        }
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if(uri != null){
                addPhotoUri(uri)
            }
        }


    companion object {
        private const val REQUEST_CAMERA_CODE = 2
        private const val RESULT_OK = -1
    }


    private fun startCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            startActivityForResult(intent, REQUEST_CAMERA_CODE)
        }
    }

    private fun startGallery() {
        getContent.launch("image/*")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERA_CODE && resultCode == RESULT_OK) {
            val imageUri = (data?.extras?.get("data") as Bitmap).toUri(requireContext())
            addPhotoUri(imageUri)
        }
    }

    private fun addPhotoUri(uri: Uri?) {
        if(uri != null) {
            val list = viewModel.photoList.value.apply {
                this?.add(uri)
            }
            viewModel.photoList.value = list
        }
    }
}