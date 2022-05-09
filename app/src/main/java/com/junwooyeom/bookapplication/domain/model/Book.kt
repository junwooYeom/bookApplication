package com.junwooyeom.bookapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val kind: String,
    val id: String,
    val eTag: String,
    val selfLink: String,
    val volumeInfo: Volume
) : Parcelable
