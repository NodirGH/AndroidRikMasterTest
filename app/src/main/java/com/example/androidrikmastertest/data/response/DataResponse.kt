package com.example.androidrikmastertest.data.response

import com.squareup.moshi.Json

data class DataResponse(
    @Json(name = "room") val room : List<String>,
    @Json(name = "cameras") val cameras : List<CamerasResponse>
)
