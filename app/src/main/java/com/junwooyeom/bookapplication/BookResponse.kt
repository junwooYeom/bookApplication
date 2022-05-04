package com.junwooyeom.bookapplication

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("items")
    val items: List<BookDto>
)
