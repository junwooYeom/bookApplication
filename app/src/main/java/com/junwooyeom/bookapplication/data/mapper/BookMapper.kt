package com.junwooyeom.bookapplication

import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.network.model.BookDto

fun BookDto.toBook(): Book =
    Book(
        kind,
        id,
        eTag,
        selfLink,
        volumeInfo,
        authors,
        publisher,
        published
    )
