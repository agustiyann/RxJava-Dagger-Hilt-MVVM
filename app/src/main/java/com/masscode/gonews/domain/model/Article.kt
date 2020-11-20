package com.masscode.gonews.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val image: String,
    val date: String
) : Parcelable