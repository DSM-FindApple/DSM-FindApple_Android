package com.findapple.findapple.app.di.module.main.post.lost

import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.features.post.usecase.GetLostListUseCase
import com.findapple.findapple.app.di.scope.MainFragmentScope
import com.findapple.findapple.app.features.lost.viewmodel.LostViewModelFactory
import com.findapple.findapple.domain.main.repository.MainRepository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class LostModule {
    @MainFragmentScope
    @Provides
    fun provideLostViewModelFactory(
        getLostListUseCase: GetLostListUseCase,
        mainRepository: MainRepository
    ): LostViewModelFactory = LostViewModelFactory(getLostListUseCase, mainRepository)

    @MainFragmentScope
    @Provides
    fun provideLostListUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetLostListUseCase = GetLostListUseCase(service, compositeDisposable)
}