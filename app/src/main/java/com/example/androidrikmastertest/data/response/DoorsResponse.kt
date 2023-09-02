package com.example.androidrikmastertest.data.response

import com.example.androidrikmastertest.dto.DoorsDto
import com.squareup.moshi.Json

data class DoorsResponse(
    @Json(name = "name") val name: String?,
    @Json(name = "room") val room: String?,
    @Json(name = "snapshot") val imageUrl: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "favorites") val favorites: Boolean?
) {
    fun mapDoorsToDto(): DoorsDto {
        return  DoorsDto(
            id = id ?: -1,
            name = name ?: "",
            imageUrl = imageUrl ?: "",
            room = room ?: "",
            favorites = favorites ?: false,
        )
    }
}