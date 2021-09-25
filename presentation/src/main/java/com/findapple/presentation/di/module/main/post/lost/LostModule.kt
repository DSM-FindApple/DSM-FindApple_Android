package com.findapple.presentation.di.module.main.post.lost

import com.findapple.presentation.domain.features.post.usecase.GetLostListUseCase
import com.findapple.presentation.di.scope.MainFragmentScope
import com.findapple.presentation.features.lost.viewmodel.LostViewModelFactory
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