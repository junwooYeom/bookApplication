package com.junwooyeom.bookapplication.network

import com.junwooyeom.bookapplication.network.model.BookResponse

interface BookInfraService {

    suspend fun getBookList(): BookResponse
}
