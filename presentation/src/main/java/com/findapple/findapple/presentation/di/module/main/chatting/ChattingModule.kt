package com.findapple.findapple.presentation.di.module.main.chatting

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.presentation.di.scope.FragmentScope
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.findapple.presentation.features.chat.ChatWebBridge
import com.findapple.findapple.presentation.features.chat.ChattingFragment
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ChattingModule {
    @MainFragmentScope
    @Provides
    fun provideChattingViewModelFactory(): ChattingViewModelFactory = ChattingViewModelFactory()

    @MainFragmentScope
    @Provides
    fun provideChattingViewModel(
        chattingViewModelFactory: ChattingViewModelFactory,
        chattingFragment: ChattingFragment
    ): ChattingViewModel =
        ViewModelProvider(chattingFragment, chattingViewModelFactory).get(ChattingViewModel::class.java)

}