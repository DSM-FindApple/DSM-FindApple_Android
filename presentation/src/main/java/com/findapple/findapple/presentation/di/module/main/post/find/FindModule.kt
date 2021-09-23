package com.findapple.findapple.presentation.di.module.main.post.find

import com.findapple.findapple.domain.features.post.usecase.GetFindListUseCase
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.findapple.presentation.features.find.viewmodel.FindViewModelFactory
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