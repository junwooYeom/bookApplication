package com.junwooyeom.bookapplication.network.model

import com.google.gson.annotations.SerializedName

data class VolumeDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("publishedDate")
    val published: String,
    @SerializedName("description")
    val description: String
)