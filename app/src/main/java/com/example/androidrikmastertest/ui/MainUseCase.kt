package com.example.androidrikmastertest.ui

import com.example.androidrikmastertest.data.repository.MainRepository
import javax.inject.Inject

interface MainUseCase {

}

class MainUseCaseImpl @Inject constructor(private val repo: MainRepository): MainUseCase{

}