package com.junwooyeom.bookapplication.domain.repository

import androidx.paging.PagingData
import com.junwooyeom.bookapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getBooks(query: String): Flow<PagingData<Book>>
}
