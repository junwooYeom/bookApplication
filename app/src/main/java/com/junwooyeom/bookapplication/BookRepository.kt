package com.junwooyeom.bookapplication

interface BookRepository {

    suspend fun getBooks(): List<Book>
}
