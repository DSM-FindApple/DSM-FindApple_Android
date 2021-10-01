package com.findapple.presentation.features.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findapple.domain.features.post.entity.Post
import com.findapple.presentation.databinding.ItemMypageBinding
import com.findapple.presentation.databinding.ItemMypageHeaderBinding
import com.findapple.presentation.features.mypage.viewmodel.MyPageViewModel

class MyPageAdapter(private val vm: MyPageViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val uploadedPostList = ArrayList<Post>()

    inner class MyPageHeaderViewHolder(private val binding: ItemMypageHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.vm = vm
        }
    }

    inner class MyPageViewHolder(binding: ItemMypageBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val binding =
                ItemMypageHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            MyPageHeaderViewHolder(binding)
        } else {
            val binding =
                ItemMypageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            MyPageViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyPageHeaderViewHolder) {
            holder.bind()
        } else if (holder is MyPageViewHolder) {
        }
    }


    override fun getItemCount(): Int = uploadedPostList.size + 1
}