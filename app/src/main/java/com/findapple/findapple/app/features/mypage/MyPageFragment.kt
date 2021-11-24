package com.findapple.findapple.app.features.mypage

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.R
import com.findapple.findapple.databinding.FragmentMypageBinding
import com.findapple.findapple.app.base.BaseFragment
import com.findapple.findapple.app.features.mypage.viewmodel.MyPageViewModel
import com.findapple.findapple.app.features.mypage.viewmodel.MyPageViewModelFactory
import javax.inject.Inject

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    @Inject
    lateinit var viewModelFactory: MyPageViewModelFactory

    override val viewModel: MyPageViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MyPageViewModel::class.java)
    }

    override fun observeEvent() {
        viewModel.run {
            showFindAppleLevelDetail.observe(viewLifecycleOwner, {
                FindAppleLevelDialog().show(
                    requireActivity().supportFragmentManager,
                    "findapple_level_detail"
                )
            })
            startLogout.observe(viewLifecycleOwner, {
                
            })
            message.observe(viewLifecycleOwner, {
                snackBarComment(it)
            })
        }
    }

}