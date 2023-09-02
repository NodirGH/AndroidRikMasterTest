package com.example.androidrikmastertest.data.response

import com.squareup.moshi.Json

data class MainResponse<T>(
    @Json(name = "success") val success: Boolean,
    @Json(name = "data") val data: T
)

data class MainResponseDoor(
    @Json(name = "success") val success: Boolean,
    @Json(name = "data") val data: List<DoorsResponse>
)