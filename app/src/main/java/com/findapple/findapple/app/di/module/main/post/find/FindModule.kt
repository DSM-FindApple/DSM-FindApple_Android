package com.findapple.findapple.app.di.module.main.post.find

import com.findapple.findapple.domain.features.post.service.PostService
import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.app.di.scope.MainFragmentScope
import com.findapple.findapple.app.features.find.viewmodel.FindViewModelFactory
import com.findapple.findapple.domain.main.repository.MainRepository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FindModule {
    @MainFragmentScope
    @Provides
    fun provideFindViewModelFactory(
        getFindListUseCase: GetFindListUseCase,
        mainRepository: MainRepository
    ): FindViewModelFactory = FindViewModelFactory(getFindListUseCase, mainRepository)

    @MainFragmentScope
    @Provides
    fun provideFindListUseCase(
        service: PostService,
        compositeDisposable: CompositeDisposable
    ): GetFindListUseCase = GetFindListUseCase(service, compositeDisposable)
}