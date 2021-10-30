package com.findapple.findapple.presentation.di.module.main.mypage

import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.features.mypage.usecase.GetUserPostListUseCase
import com.findapple.findapple.presentation.features.mypage.viewmodel.MyPageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MyPageModule {
    @MainFragmentScope
    @Provides
    fun provideMyPageViewModelFactory(
        userUseCase: GetUserUseCase,
        userPostUseCase: GetUserPostListUseCase
    ): MyPageViewModelFactory = MyPageViewModelFactory(userUseCase, userPostUseCase)
}