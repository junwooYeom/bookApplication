package com.junwooyeom.bookapplication

import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val bookRepository: BookRepository
){
    suspend operator fun invoke() = bookRepository.getBooks()
}
