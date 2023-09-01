package com.example.androidrikmastertest.data.response

import com.example.androidrikmastertest.dto.CamerasDto
import com.squareup.moshi.Json

data class CamerasResponse(
    @Json(name = "name") val name: String?,
    @Json(name = "snapshot") val imageUrl: String?,
    @Json(name = "room") val room: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "favorites") val favorites: Boolean?,
    @Json(name = "rec") val rec: Boolean?
)  {
    fun mapCamerasToDto(): CamerasDto {
        return CamerasDto(
            id = id ?: -1,
            name = name ?: "",
            imageUrl = imageUrl ?: "",
            room = room ?: "",
            favorites = favorites ?: false,
            rec = rec ?: false
            )
    }
}
