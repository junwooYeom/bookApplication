package com.junwooyeom.bookapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val smallThumbnail: String,
    val thumbnail: String
): Parcelable