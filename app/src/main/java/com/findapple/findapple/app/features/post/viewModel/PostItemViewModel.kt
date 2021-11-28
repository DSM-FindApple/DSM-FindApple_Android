package com.findapple.findapple.app.features.post.viewModel

import com.findapple.findapple.BR
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BasePostViewModel
import com.findapple.findapple.app.bindingadapter.MultipleRecyclerViewItem
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import com.findapple.findapple.app.toRecyclerViewItem
import com.findapple.findapple.domain.features.post.entity.Post

data class PostItemViewModel(val post: Post, val postVm: BasePostViewModel) {
    var isMyPost = false
    val imagesView = post.images.toRecyclerViewItem()
}

fun PostItemViewModel.toRecyclerItem(myPost: Boolean): MultipleRecyclerViewItem =
    MultipleRecyclerViewItem(
        data1 = this.apply { isMyPost = myPost },
        variableId1 = BR.vm,
        data2 = this.postVm,
        variableId2 = BR.postVm,
        itemLayoutId = R.layout.item_post
    )