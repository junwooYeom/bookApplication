package com.junwooyeom.bookapplication.domain.repository

import com.junwooyeom.bookapplication.domain.model.Book

interface BookRepository {

    suspend fun getBooks(): List<Book>
}
