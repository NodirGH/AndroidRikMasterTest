package com.example.androidrikmastertest.ui

import com.example.androidrikmastertest.data.repository.MainRepository
import com.example.androidrikmastertest.dto.CamerasDto
import com.example.androidrikmastertest.dto.DoorsDto
import javax.inject.Inject

interface MainUseCase {
    suspend fun getCameraInfo(): List<CamerasDto>
    suspend fun getDoorInfo(): List<DoorsDto>
}

class MainUseCaseImpl @Inject constructor(private val repo: MainRepository): MainUseCase{

    override suspend fun getCameraInfo(): List<CamerasDto> {
        return repo.getCameraInfo()
    }

    override suspend fun getDoorInfo(): List<DoorsDto> {
        return repo.getDoorInfo()
    }
}