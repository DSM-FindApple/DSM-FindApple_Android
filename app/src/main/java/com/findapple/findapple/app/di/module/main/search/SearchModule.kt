package com.findapple.findapple.app.di.module.main.search

import androidx.lifecycle.ViewModelProvider
import com.findapple.findapple.app.di.scope.FragmentScope
import com.findapple.findapple.app.features.search.SearchFragment
import com.findapple.findapple.app.features.search.viewmodel.SearchViewModel
import com.findapple.findapple.app.features.search.viewmodel.SearchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SearchModule {
    @FragmentScope
    @Provides
    fun provideSearchViewModelFactory(): SearchViewModelFactory = SearchViewModelFactory()

    @FragmentScope
    @Provides
    fun provideSearchViewModel(
        factory: SearchViewModelFactory,
        fragment: SearchFragment
    ): SearchViewModel =
        ViewModelProvider(fragment, factory).get(SearchViewModel::class.java)
}