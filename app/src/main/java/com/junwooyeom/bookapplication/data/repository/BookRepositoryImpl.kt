package com.junwooyeom.bookapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.junwooyeom.bookapplication.data.BookPagingSource
import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.domain.repository.BookRepository
import com.junwooyeom.bookapplication.network.BookInfraService
import com.junwooyeom.bookapplication.data.mapper.toBook
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookInfraService: BookInfraService
) : BookRepository {
    override fun getBooks(query: String): Flow<PagingData<Book>> {
        return Pager(
            PagingConfig(pageSize = 10)
        ) {
            BookPagingSource(bookInfraService, query)
        }.flow
    }
}
