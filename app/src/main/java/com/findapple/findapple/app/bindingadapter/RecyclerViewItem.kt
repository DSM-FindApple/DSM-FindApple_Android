package com.findapple.findapple.app.bindingadapter

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

data class MultipleRecyclerViewItem(
    @LayoutRes val itemLayoutId: Int,
    val data1: Any,
    val variableId1: Int,
    val data2: Any,
    val variableId2: Int
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId1, data1)
        binding.setVariable(variableId2, data2)
    }
}