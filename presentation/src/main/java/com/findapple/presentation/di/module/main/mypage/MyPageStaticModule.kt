package com.findapple.presentation.di.module.main.mypage

import com.findapple.data.features.mypage.UserApi
import com.findapple.data.features.mypage.datasource.UserDataSource
import com.findapple.data.features.mypage.datasource.UserDataSourceImpl
import com.findapple.data.features.mypage.repository.UserRepositoryImpl
import com.findapple.data.local.database.dao.UserDao
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.domain.features.mypage.service.UserService
import com.findapple.domain.features.mypage.service.UserServiceImpl
import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import com.findapple.domain.features.mypage.usecase.GetUserPostListUseCase
import com.findapple.presentation.di.scope.MainFragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MyPageStaticModule {

    @MainFragmentScope
    @Provides
    fun provideUserPostListUseCase(
        service: UserService,
        compositeDisposable: CompositeDisposable
    ): GetUserPostListUseCase = GetUserPostListUseCase(service, compositeDisposable)

    @MainFragmentScope
    @Provides
    fun provideGetUserUseCase(
        userRepository: UserRepository,
        compositeDisposable: CompositeDisposable
    ): GetUserUseCase = GetUserUseCase(userRepository, compositeDisposable)

    @MainFragmentScope
    @Provides
    fun provideUserService(
        repository: UserRepository,
        errorHandler: ErrorHandler
    ): UserService = UserServiceImpl(repository, errorHandler)

    @MainFragmentScope
    @Provides
    fun provideUserRepository(
        dataSource: UserDataSource
    ): UserRepository = UserRepositoryImpl(dataSource)

    @MainFragmentScope
    @Provides
    fun provideUserDataSource(api: UserApi, userDao: UserDao): UserDataSource = UserDataSourceImpl(api, userDao)
}