package com.example.androidrikmastertest.dto

data class CamerasDto(
    val name: String = "",
    val imageUrl: String = "",
    val room: String = "",
    val id: Int = 0,
    val favorites: Boolean = false,
    val rec: Boolean = false
)