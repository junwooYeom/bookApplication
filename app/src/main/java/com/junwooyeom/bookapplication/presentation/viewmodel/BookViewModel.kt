package com.junwooyeom.bookapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.domain.usecase.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {
    fun getBookList(query: String) : Flow<PagingData<Book>> = getBooksUseCase(query).cachedIn(viewModelScope)
}
