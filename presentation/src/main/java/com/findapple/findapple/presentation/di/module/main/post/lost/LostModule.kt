package com.findapple.findapple.presentation.di.module.main.post.lost

import com.findapple.findapple.domain.post.usecase.GetLostListUseCase
import com.findapple.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class LostModule {
    @MainFragmentScope
    @Provides
    fun provideLostViewModelFactory(
        getLostListUseCase: GetLostListUseCase
    ): LostViewModelFactory = LostViewModelFactory(getLostListUseCase)
}