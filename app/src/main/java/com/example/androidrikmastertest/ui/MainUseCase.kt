package com.example.androidrikmastertest.ui

import com.example.androidrikmastertest.data.repository.MainRepository
import com.example.androidrikmastertest.dto.CamerasDto
import javax.inject.Inject

interface MainUseCase {
    suspend fun getCameraInfo(): List<CamerasDto>
}

class MainUseCaseImpl @Inject constructor(private val repo: MainRepository): MainUseCase{

    override suspend fun getCameraInfo(): List<CamerasDto> {
        return repo.getCameraInfo()
    }
}