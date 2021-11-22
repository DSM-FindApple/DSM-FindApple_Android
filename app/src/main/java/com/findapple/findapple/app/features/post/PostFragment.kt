package com.findapple.findapple.app.features.post

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentPostBinding
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.post.adapter.CategoryAdapter
import com.findapple.findapple.app.features.post.viewModel.PostViewModel
import com.findapple.findapple.app.features.post.viewModel.PostViewModelFactory
import com.findapple.findapple.app.main.viewmodel.MainViewModel
import com.findapple.findapple.app.toRealPath
import gun0912.tedimagepicker.builder.TedImagePicker
import gun0912.tedimagepicker.builder.TedRxImagePicker
import io.reactivex.android.schedulers.AndroidSchedulers
import java.io.File
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

            message.observe(viewLifecycleOwner, {
                snackBarComment(it)
            })

            donePost.observe(viewLifecycleOwner, {
                onBackPressed()
            })

            startGallery.observe(viewLifecycleOwner, {
                TedRxImagePicker.with(requireContext())
                    .startMultiImage()
                    .subscribe({ uri ->
                        photoList.value = photoList.value?.apply { addAll(uri) }
                        photoRequestList.addAll(uri.map { File(it.toRealPath(requireContext())) })
                    }, Throwable::printStackTrace)
            })

        }
    }

}