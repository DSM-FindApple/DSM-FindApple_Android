package com.findapple.findapple.app.features.post

import android.os.Bundle
import android.view.View
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseDialog
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.databinding.DialogMorePostBinding

class MorePostDialog(val viewModel: BasePostViewModel, val postId: Long): BaseDialog<DialogMorePostBinding>(R.layout.dialog_more_post) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            moreDeleteTv.setOnClickListener {
                viewModel.deletePost()
            }
            moreEditTv.setOnClickListener {

            }
        }

    }
}