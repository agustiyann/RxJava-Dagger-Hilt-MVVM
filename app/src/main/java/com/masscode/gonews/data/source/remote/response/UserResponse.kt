package com.masscode.gonews.data.source.remote.response

import com.squareup.moshi.Json

data class UserResponse(
    @Json(name = "id")
    val id: Int,

    @Json(name = "username")
    val username: String,

    @Json(name = "avatar")
    val avatar: String,

    @Json(name = "job")
    val job: String,

    @Json(name = "slogan")
    val slogan: String
)