package com.example.androidrikmastertest.utils

import androidx.lifecycle.MutableLiveData

class SingleLiveData<T> : MutableLiveData<SingleEvent<T>> {

    constructor()

    constructor(value: T) : super(SingleEvent<T>(value))

    fun postSingleValue(value: T) {
        postValue(SingleEvent<T>(value))
    }

    fun setSingleValue(value: T) {
        setValue(SingleEvent<T>(value))
    }
}