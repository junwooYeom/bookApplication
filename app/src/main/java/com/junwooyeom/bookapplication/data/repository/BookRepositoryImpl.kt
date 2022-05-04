package com.junwooyeom.bookapplication.data.repository

import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.domain.repository.BookRepository
import com.junwooyeom.bookapplication.network.BookInfraService
import com.junwooyeom.bookapplication.toBook
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookInfraService: BookInfraService
) : BookRepository {
    override suspend fun getBooks(): List<Book> = bookInfraService.getBookList().items.map { it.toBook() }
}
