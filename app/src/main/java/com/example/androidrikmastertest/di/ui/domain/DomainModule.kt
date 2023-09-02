package com.example.androidrikmastertest.di.ui.domain

import com.example.androidrikmastertest.data.repository.MainRepository
import com.example.androidrikmastertest.ui.MainUseCase
import com.example.androidrikmastertest.ui.MainUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideMainUseCase(repository: MainRepository): MainUseCase = MainUseCaseImpl(repository)
}