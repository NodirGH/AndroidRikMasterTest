package com.example.androidrikmastertest.base

import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
import com.example.androidrikmastertest.utils.LiveEvent
import com.example.androidrikmastertest.utils.SingleEvent
import com.example.androidrikmastertest.utils.SingleLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
//import timber.log.Timber


abstract class BaseViewModel : ViewModel() {
    val errorOther = SingleLiveData<Throwable>()
    var loading = LiveEvent<Boolean>()
    val handler = CoroutineExceptionHandler { _, exception ->
        errorProcess(exception)
    }

//    val vmScope = viewModelScope + handler + Dispatchers.IO

    fun errorProcess(throwable: Throwable, f: ((t: Throwable) -> Unit)? = null) {
//        viewModelScope.launch {
//            loading.postValue(false)
//            throwable.printStackTrace()
//            Timber.d(throwable.message)
//            errorOther.postValue(SingleEvent(throwable))
//        }
    }

    fun CoroutineScope.loadingLaunch(suspendCall: suspend () -> Unit): Job {
        loading.postValue(true)
        return launch {
            suspendCall.invoke()
            loading.postValue(false)
        }
    }

    fun <T> Flow<T>.handleErrors(): Flow<T> = flow {
        try {
            collect { value -> emit(value) }
        } catch (e: Throwable) {
            errorProcess(e)
        }
    }
}