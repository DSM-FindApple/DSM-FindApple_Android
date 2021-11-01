package com.findapple.findapple.presentation.features.post.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findapple.findapple.R
import com.findapple.findapple.databinding.ItemCategoryBinding
import com.findapple.findapple.presentation.features.post.model.Category
import com.findapple.findapple.presentation.features.post.viewModel.PostViewModel

class CategoryAdapter(private val viewModel: PostViewModel) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories =
        arrayListOf(
            Category(R.drawable.ic_category_earphone, "이어폰", false),
            Category(R.drawable.ic_category_phone, "휴대폰", false),
            Category(R.drawable.ic_category_electric, "전자기기", false),
            Category(R.drawable.ic_category_cloth, "의류", false),
            Category(R.drawable.ic_category_ring, "악세사리", false),
            Category(R.drawable.ic_category_wallet, "지갑", false),
            Category(R.drawable.ic_category_car, "자동차", false)
        )

    inner class CategoryViewHolder(val binding: ItemCategoryBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category, position: Int) {
            binding.run {
                title = category.title
                val icon = context.getDrawable(category.iconResId)
                categoryIv.setImageDrawable(icon)
                setPosition(position)
                vm = viewModel
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding: ItemCategoryBinding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, position)
    }

    override fun getItemCount(): Int =
        categories.size
}