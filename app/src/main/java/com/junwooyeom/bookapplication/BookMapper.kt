package com.junwooyeom.bookapplication

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
