package com.findapple.presentation.di.module.main.chatting

import com.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.presentation.features.chat.viewmodel.ChattingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ChattingModule {
    @MainFragmentScope
    @Provides
    fun provideChattingViewModelFactory(): ChattingViewModelFactory = ChattingViewModelFactory()
}