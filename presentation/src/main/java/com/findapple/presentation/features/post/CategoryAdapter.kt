package com.findapple.presentation.features.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.findapple.presentation.R
import com.findapple.presentation.databinding.ItemCategoryBinding
import com.findapple.presentation.features.post.model.Category
import com.findapple.presentation.features.post.viewModel.PostViewModel

class CategoryAdapter(private val vm: PostViewModel) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories = arrayListOf(
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
            binding.category = category
            binding.run {
                categoryCl.setOnClickListener {
                    category.selected = !category.selected
                    vm.categoryClicked(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemCategoryBinding =
            DataBindingUtil.inflate(inflater, viewType, parent, false)
        return CategoryViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, position)
    }

    override fun getItemCount(): Int =
        categories.size
}