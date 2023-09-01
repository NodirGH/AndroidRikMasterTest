package com.example.androidrikmastertest.data.repository

import com.example.androidrikmastertest.data.service.MainService
import com.example.androidrikmastertest.dto.CamerasDto
import javax.inject.Inject
import javax.inject.Singleton

interface MainRepository {
    suspend fun getCameraInfo(): List<CamerasDto>
}

@Singleton
class MainRepositoryImpl @Inject constructor(private val service: MainService): MainRepository {

    override suspend fun getCameraInfo(): List<CamerasDto> {
        return try {
            service.getCameraInfo().data.cameras.map { it.mapCamerasToDto() }
        }catch (e: Exception){
            emptyList()
        }
    }
}