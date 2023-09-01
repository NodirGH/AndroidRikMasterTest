package com.example.androidrikmastertest.di.ui

import com.example.androidrikmastertest.adapter.MainAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    fun provideMainAdapter() = MainAdapter()
}