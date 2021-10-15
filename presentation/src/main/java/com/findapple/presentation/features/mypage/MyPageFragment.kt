package com.findapple.presentation.features.mypage

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mypageRv.run {
            adapter = MyPageAdapter(viewModel)
            layoutManager = LinearLayoutManager(context)
        }
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