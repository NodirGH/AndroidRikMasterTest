package com.example.androidrikmastertest.di.ui

import com.example.androidrikmastertest.adapter.CameraAdapter
import com.example.androidrikmastertest.adapter.DoorAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    fun provideMainAdapter() = CameraAdapter()

    @Provides
    fun provideDoorAdapter() = DoorAdapter()
}