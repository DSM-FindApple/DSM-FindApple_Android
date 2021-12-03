package com.findapple.findapple.app.features.search

import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.search.viewmodel.SearchViewModel
import com.findapple.findapple.databinding.FragmentSearchBinding
import javax.inject.Inject

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    @Inject
    override lateinit var viewModel: SearchViewModel
    override fun observeEvent() {

    }
}