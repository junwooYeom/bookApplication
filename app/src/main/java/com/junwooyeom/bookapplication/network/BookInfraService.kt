package com.junwooyeom.bookapplication.network

import com.junwooyeom.bookapplication.network.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookInfraService {

    @GET("/")
    suspend fun getBookList(
        @Query("q") query: String,
    ): BookResponse
}
