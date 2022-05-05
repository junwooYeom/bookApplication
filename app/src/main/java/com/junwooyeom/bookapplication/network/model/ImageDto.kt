package com.junwooyeom.bookapplication.network.model

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
)