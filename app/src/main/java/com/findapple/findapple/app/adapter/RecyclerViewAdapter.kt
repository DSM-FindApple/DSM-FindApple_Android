package com.findapple.findapple.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.findapple.findapple.app.bindingadapter.BindingViewHolder
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem

class RecyclerViewAdapter : RecyclerView.Adapter<BindingViewHolder>() {

    private val items = mutableListOf<RecyclerViewItem>()
    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        items[position].bind(holder.binding)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].itemLayoutId
    }

    fun updateData(newItems: List<RecyclerViewItem>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addData(newItem: RecyclerViewItem) {
        this.items.add(newItem)
        notifyDataSetChanged()
    }
}

