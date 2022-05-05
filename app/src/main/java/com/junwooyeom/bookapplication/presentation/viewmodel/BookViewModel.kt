package com.junwooyeom.bookapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.junwooyeom.bookapplication.domain.usecase.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {

}
