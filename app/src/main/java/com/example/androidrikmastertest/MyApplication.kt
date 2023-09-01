package com.example.androidrikmastertest

import android.app.Application
import com.example.androidrikmastertest.utils.LiveEvent
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        @JvmStatic
        val fcmMessages: LiveEvent<Any> = LiveEvent()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}