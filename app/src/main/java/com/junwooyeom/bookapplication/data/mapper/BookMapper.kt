package com.junwooyeom.bookapplication.data.mapper

import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.network.model.BookDto

fun BookDto.toBook(): Book =
    Book(
        kind,
        id,
        eTag,
        selfLink,
        volumeInfo.toVolume() ,
    )
