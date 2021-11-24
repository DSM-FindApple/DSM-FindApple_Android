package com.findapple.findapple.app.di.module.main.mypage

import com.findapple.findapple.app.di.scope.MainFragmentScope
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.domain.features.mypage.usecase.GetUserDetailUseCase
import com.findapple.findapple.app.features.mypage.viewmodel.MyPageViewModelFactory
import com.findapple.findapple.domain.features.mypage.service.UserService
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MyPageModule {
    @MainFragmentScope
    @Provides
    fun provideMyPageViewModelFactory(
        userUseCase: GetUserUseCase,
        userPostUseCase: GetUserDetailUseCase,
        userService: UserService,
        compositeDisposable: CompositeDisposable
    ): MyPageViewModelFactory = MyPageViewModelFactory(userUseCase, userPostUseCase, userService, compositeDisposable)
}