package com.findapple.presentation.features.mypage

import androidx.lifecycle.ViewModelProvider
import com.findapple.presentation.R
import com.findapple.presentation.databinding.FragmentMypageBinding
import com.findapple.presentation.base.BaseFragment
import com.findapple.presentation.features.mypage.viewmodel.MyPageViewModel
import com.findapple.presentation.features.mypage.viewmodel.MyPageViewModelFactory
import javax.inject.Inject

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    @Inject
    lateinit var viewModelFactory: MyPageViewModelFactory

    override val viewModel: MyPageViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MyPageViewModel::class.java)
    }

    override fun observeEvent() {
        viewModel.showFindAppleLevelDetail.observe(viewLifecycleOwner, {
            FindAppleLevelDialog().show(
                requireActivity().supportFragmentManager,
                "findapple_level_detail"
            )
        })
    }

}