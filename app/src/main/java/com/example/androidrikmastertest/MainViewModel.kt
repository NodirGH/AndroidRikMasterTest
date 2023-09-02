package com.example.androidrikmastertest

import androidx.lifecycle.MutableLiveData
import com.example.androidrikmastertest.base.BaseViewModel
import com.example.androidrikmastertest.dto.CamerasDto
import com.example.androidrikmastertest.dto.DoorsDto
import com.example.androidrikmastertest.ui.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : BaseViewModel() {

    var cameras = MutableLiveData<List<CamerasDto>>()
    var door = MutableLiveData<List<DoorsDto>>()

    fun getCameraInfo(){
        vmScope.loadingLaunch {
            val result = mainUseCase.getCameraInfo()
            cameras.postValue(result)
        }
    }

    fun getDoorInfo(){
        vmScope.loadingLaunch {
            val result = mainUseCase.getDoorInfo()
            door.postValue(result)
        }
    }
}