package com.findapple.findapple.app.di.module.main.mypage

import com.findapple.findapple.app.di.scope.MainFragmentScope
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.features.mypage.usecase.GetUserDetailUseCase
import com.findapple.findapple.app.features.mypage.viewmodel.MyPageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MyPageModule {
    @MainFragmentScope
    @Provides
    fun provideMyPageViewModelFactory(
        userUseCase: GetUserUseCase,
        userPostUseCase: GetUserDetailUseCase
    ): MyPageViewModelFactory = MyPageViewModelFactory(userUseCase, userPostUseCase)
}