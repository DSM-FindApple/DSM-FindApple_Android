package com.findapple.findapple.app.di.module.main.chatting

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.features.chat.detail.ChatDetailFragment
import com.findapple.findapple.app.features.chat.detail.viewmodel.ChatDetailViewModel
import com.findapple.findapple.app.features.chat.detail.viewmodel.ChatDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ChatDetailModule {
    @FragmentScope
    @Provides
    fun provideChatDetailViewModelFactory(): ChatDetailViewModelFactory = ChatDetailViewModelFactory()

    @FragmentScope
    @Provides
    fun provideChatDetailViewModel(
        chatDetailViewModelFactory: ChatDetailViewModelFactory,
        chatDetailFragment: ChatDetailFragment
    ): ChatDetailViewModel =
        ViewModelProvider(chatDetailFragment, chatDetailViewModelFactory).get(ChatDetailViewModel::class.java)
}