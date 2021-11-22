package com.findapple.findapple.app.features.post.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.findapple.findapple.databinding.ItemPhotoBinding
import com.findapple.findapple.databinding.ItemPostPhotoBinding
import com.findapple.findapple.app.features.post.viewModel.PostViewModel

class PostPhotoAdapter(private val vm: PostViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val images = mutableListOf<Uri>()

    companion object{
        private const val ADD_PHOTO = 1
        private const val PHOTO = 2
    }

    inner class PhotoViewHolder(val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.vm = vm
            binding.apply {
                setVariable(BR.vm, vm)
                setVariable(BR.position, position)
            }
            binding.photoIv.setImageURI(images[position])
        }
    }

    inner class PostPhotoViewHolder(val binding: ItemPostPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ADD_PHOTO) {
            val binding =
                ItemPostPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            PostPhotoViewHolder(binding)
        } else {
            val binding =
                ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            PhotoViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostPhotoViewHolder) {
            holder.binding.setVariable(BR.vm, vm)
        } else if (holder is PhotoViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == images.size) ADD_PHOTO else PHOTO
    }

    override fun getItemCount(): Int =
        images.size + 1

    fun updateData(images: List<Uri>) {
        this.images.addAll(images)
        notifyDataSetChanged()
    }
}