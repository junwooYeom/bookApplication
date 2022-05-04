package com.junwooyeom.bookapplication.network.model

import com.google.gson.annotations.SerializedName
import com.junwooyeom.bookapplication.network.model.BookDto

data class BookResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("items")
    val items: List<BookDto>
)
