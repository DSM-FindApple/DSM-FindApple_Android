package com.findapple.findapple.presentation.di.module.main.chatting

import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.findapple.presentation.features.chat.viewmodel.ChattingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ChattingModule {
    @MainFragmentScope
    @Provides
    fun provideChattingViewModelFactory(): ChattingViewModelFactory = ChattingViewModelFactory()
}