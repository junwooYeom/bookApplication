package com.junwooyeom.bookapplication.domain.usecase

import com.junwooyeom.bookapplication.domain.repository.BookRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val bookRepository: BookRepository
){
    suspend operator fun invoke() = bookRepository.getBooks()
}
