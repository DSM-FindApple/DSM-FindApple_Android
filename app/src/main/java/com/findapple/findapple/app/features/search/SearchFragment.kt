package com.findapple.findapple.app.features.search

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.findapple.findapple.R
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.search.viewmodel.SearchViewModel
import com.findapple.findapple.databinding.FragmentSearchBinding
import javax.inject.Inject

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    @Inject
    override lateinit var viewModel: SearchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idArgs by navArgs<SearchFragmentArgs>()
        val type = idArgs.type
        binding.searchWv.addJavascriptInterface(SearchWebBridge(this), "Search")
        binding.url =
            "http://www.findapple.app.s3-website.ap-northeast-2.amazonaws.com/search?type=$type"
    }

    override fun observeEvent() {

    }
}