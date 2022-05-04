package com.junwooyeom.bookapplication

data class Book(
    val kind: String,
    val id: String,
    val eTag: String,
    val selfLink: String,
    val volumeInfo: String,
    val authors: List<String>,
    val publisher: String,
    val published: String,
)
