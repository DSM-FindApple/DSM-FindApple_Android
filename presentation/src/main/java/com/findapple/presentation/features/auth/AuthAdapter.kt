package com.findapple.presentation.features.auth

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findapple.presentation.databinding.ItemWelcomeAuthBinding

class AuthAdapter : RecyclerView.Adapter<AuthAdapter.AuthViewHolder>() {

    inner class AuthViewHolder(binding: ItemWelcomeAuthBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AuthViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = 4
}