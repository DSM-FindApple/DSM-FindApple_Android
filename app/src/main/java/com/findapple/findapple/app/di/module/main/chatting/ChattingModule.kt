package com.findapple.findapple.app.di.module.main.chatting

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.app.di.scope.MainFragmentScope
import com.findapple.findapple.app.features.chat.ChattingFragment
import com.findapple.findapple.app.features.chat.viewmodel.ChattingViewModel
import com.findapple.findapple.app.features.chat.viewmodel.ChattingViewModelFactory
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