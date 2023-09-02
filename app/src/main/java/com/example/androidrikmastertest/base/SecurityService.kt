package com.example.androidrikmastertest.base

import android.app.Application
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.androidrikmastertest.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class SecurityService @Inject constructor(
    val application: Application,
) {

    fun openMainActivityWithClearStack() {
        CoroutineScope(Dispatchers.IO).launch {
        }.invokeOnCompletion {
            Handler(Looper.getMainLooper()).post {
                val intent = Intent(application, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                application.startActivity(intent)
            }
        }
    }
}