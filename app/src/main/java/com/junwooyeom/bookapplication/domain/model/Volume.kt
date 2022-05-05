package com.junwooyeom.bookapplication.domain.model

data class Volume(
    val title: String,
    val subTitle: String,
    val authors: List<String>,
    val publisher: String,
    val published: String,
    val description: String
)
