package com.findapple.presentation.di.module.main.post.lost

import com.findapple.domain.features.post.service.PostService
import com.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class LostModule {
    @MainFragmentScope
    @Provides
    fun provideLostViewModelFactory(
        getLostListUseCase: GetLostListUseCase
    ): LostViewModelFactory = LostViewModelFactory(getLostListUseCase)

    @MainFragmentScope
    @Provides
    fun provideLostListUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetLostListUseCase = GetLostListUseCase(service, compositeDisposable)
}