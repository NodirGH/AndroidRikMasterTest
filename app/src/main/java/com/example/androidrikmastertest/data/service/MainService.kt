package com.example.androidrikmastertest.data.service

import com.example.androidrikmastertest.data.response.DataResponse
import com.example.androidrikmastertest.data.response.MainResponse
import com.example.androidrikmastertest.data.url.CameraAndDoors
import retrofit2.http.GET

interface MainService {

    @GET(CameraAndDoors.CAMERA)
    suspend fun getCameraInfo(): MainResponse<DataResponse>
}