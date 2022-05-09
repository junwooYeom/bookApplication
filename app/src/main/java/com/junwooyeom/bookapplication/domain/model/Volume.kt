package com.junwooyeom.bookapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Volume(
    val title: String,
    val subTitle: String,
    val authors: List<String>,
    val publisher: String,
    val published: String,
    val description: String,
    val categories: List<String>,
    val links: Image,
): Parcelable
