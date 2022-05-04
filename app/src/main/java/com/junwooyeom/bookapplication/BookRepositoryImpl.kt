package com.junwooyeom.bookapplication

import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookInfraService: BookInfraService
) : BookRepository{
    override suspend fun getBooks(): List<Book> = bookInfraService.getBookList().items.map { it.toBook() }
}
