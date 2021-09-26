package com.findapple.presentation.di.module.main.mypage

import com.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.presentation.features.mypage.viewmodel.MyPageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MyPageModule {
    @MainFragmentScope
    @Provides
    fun provideMyPageViewModelFactory(
        useCase: GetUserUseCase
    ): MyPageViewModelFactory = MyPageViewModelFactory(useCase)
}