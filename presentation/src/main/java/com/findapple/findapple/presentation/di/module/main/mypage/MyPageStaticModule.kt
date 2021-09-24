package com.findapple.findapple.presentation.di.module.main.mypage

import com.findapple.findapple.data.features.mypage.repository.UserRepositoryImpl
import com.findapple.findapple.domain.errorhandler.ErrorHandler
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.findapple.domain.features.mypage.service.UserService
import com.findapple.findapple.domain.features.mypage.service.UserServiceImpl
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MyPageStaticModule {

    @MainFragmentScope
    @Provides
    fun provideGetUserUseCase(
        userService: UserService,
        compositeDisposable: CompositeDisposable
    ): GetUserUseCase = GetUserUseCase(userService, compositeDisposable)

    @MainFragmentScope
    @Provides
    fun provideUserService(
        repository: UserRepository,
        errorHandler: ErrorHandler
    ): UserService = UserServiceImpl(repository, errorHandler)

    @MainFragmentScope
    @Provides
    fun provideUserRepository(
        //todo make datasource
    ): UserRepository = UserRepositoryImpl()
}