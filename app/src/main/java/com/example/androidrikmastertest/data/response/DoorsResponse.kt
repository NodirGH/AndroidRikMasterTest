package com.example.androidrikmastertest.data.response

import com.squareup.moshi.Json

data class DoorsResponse(
    @Json(name = "name") val name: String,
    @Json(name = "room") val room: String,
    @Json(name = "id") val id: Int,
    @Json(name = "favorites") val favorites: Boolean
)