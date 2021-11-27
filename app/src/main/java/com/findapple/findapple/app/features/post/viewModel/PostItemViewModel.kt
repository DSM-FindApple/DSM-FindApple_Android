package com.findapple.findapple.app.features.post.viewModel

import com.findapple.findapple.BR
import com.findapple.findapple.R
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem
import com.findapple.findapple.app.toRecyclerViewItem
import com.findapple.findapple.domain.features.post.entity.Post

data class PostItemViewModel(val post: Post) {
    var isMyPost = false
    val imagesView = post.images.toRecyclerViewItem()
}

fun PostItemViewModel.toRecyclerItem(myPost: Boolean): RecyclerViewItem =
    RecyclerViewItem(
        data = this.apply { isMyPost = myPost },
        variableId = BR.vm,
        itemLayoutId = R.layout.item_post
    )