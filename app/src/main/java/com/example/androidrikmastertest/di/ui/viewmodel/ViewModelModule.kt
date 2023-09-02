package com.example.androidrikmastertest.di.ui.viewmodel

import com.example.androidrikmastertest.MainViewModel
import com.example.androidrikmastertest.ui.MainUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideMainViewModel(mainUseCase: MainUseCase) = MainViewModel(mainUseCase)
}