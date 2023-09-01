package com.example.androidrikmastertest.di.data

import com.example.androidrikmastertest.data.repository.MainRepository
import com.example.androidrikmastertest.data.repository.MainRepositoryImpl
import com.example.androidrikmastertest.data.service.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(service: MainService): MainRepository {
        return MainRepositoryImpl(service)
    }
}