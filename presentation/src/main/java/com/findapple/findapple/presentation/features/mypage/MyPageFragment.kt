package com.findapple.findapple.presentation.features.mypage

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentMypageBinding
import com.findapple.findapple.presentation.base.BaseFragment
import com.findapple.findapple.presentation.features.mypage.viewmodel.MyPageViewModel
import com.findapple.findapple.presentation.features.mypage.viewmodel.MyPageViewModelFactory
import javax.inject.Inject

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    @Inject
    lateinit var viewModelFactory: MyPageViewModelFactory

    override val viewModel: MyPageViewModel by lazy {
        ViewModelProvider(this,viewModelFactory).get(MyPageViewModel::class.java)
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}