package com.example.androidrikmastertest.data.repository

import com.example.androidrikmastertest.data.service.MainService
import com.example.androidrikmastertest.dto.CamerasDto
import com.example.androidrikmastertest.dto.DoorsDto
import javax.inject.Inject
import javax.inject.Singleton

interface MainRepository {
    suspend fun getCameraInfo(): List<CamerasDto>
    suspend fun getDoorInfo(): List<DoorsDto>
}

@Singleton
class MainRepositoryImpl @Inject constructor(private val service: MainService): MainRepository {

    override suspend fun getCameraInfo(): List<CamerasDto> {
        return try {
            service.getCameraInfo().data.cameras.map { it.mapCamerasToDto() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getDoorInfo(): List<DoorsDto> {
        return try {
            val result = service.getDoorInfo().data.map { it.mapDoorsToDto() }
            result
        } catch (e: Exception) {
            emptyList()
        }
    }
}