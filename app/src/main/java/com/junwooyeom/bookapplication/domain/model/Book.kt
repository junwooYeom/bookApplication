package com.junwooyeom.bookapplication.domain.model

data class Book(
    val kind: String,
    val id: String,
    val eTag: String,
    val selfLink: String,
    val volumeInfo: Volume
)
