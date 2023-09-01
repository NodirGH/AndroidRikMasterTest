package com.example.androidrikmastertest

import com.example.androidrikmastertest.base.BaseViewModel
import com.example.androidrikmastertest.ui.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : BaseViewModel() {

}