package com.masscode.gonews.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val username: String,
    val avatar: String,
    val job: String,
    val slogan: String
) : Parcelable