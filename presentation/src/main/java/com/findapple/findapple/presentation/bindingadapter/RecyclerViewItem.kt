package com.findapple.findapple.presentation.bindingadapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

data class RecyclerViewItem(
    @LayoutRes val itemLayoutId: Int,
    val data: Any,
    val variableId: Int
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, data)
    }
}