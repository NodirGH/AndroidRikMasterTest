package com.example.androidrikmastertest.data.repository

import com.example.androidrikmastertest.data.service.MainService
import javax.inject.Inject
import javax.inject.Singleton

interface MainRepository {

}

@Singleton
class MainRepositoryImpl @Inject constructor(private val service: MainService): MainRepository {

}