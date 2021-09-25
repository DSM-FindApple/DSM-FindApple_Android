package com.findapple.presentation.di.module.main.post.find

import com.findapple.presentation.domain.features.post.usecase.GetFindListUseCase
import com.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.presentation.features.find.viewmodel.FindViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class FindModule {
    @MainFragmentScope
    @Provides
    fun provideFindViewModelFactory(
        getFindListUseCase: GetFindListUseCase
    ): FindViewModelFactory = FindViewModelFactory(getFindListUseCase)
}