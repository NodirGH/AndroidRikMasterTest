package com.example.androidrikmastertest.di.ui

import com.example.androidrikmastertest.base.SecurityService
import com.example.androidrikmastertest.data.interceptor.JsonParseInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideAuthSecurityListener(securityService: SecurityService): JsonParseInterceptor.Listener =
        object : JsonParseInterceptor.Listener {
            override fun openHomeWithClearStack() {
                securityService.openMainActivityWithClearStack()
            }
        }
}