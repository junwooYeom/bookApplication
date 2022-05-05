package com.junwooyeom.bookapplication.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.junwooyeom.bookapplication.data.mapper.toBook
import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.network.BookInfraService

class BookPagingSource(
    private val infraService: BookInfraService,
    private val query: String
) : PagingSource<Int, Book>(){
    override fun getRefreshKey(state: PagingState<Int, Book>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = infraService.getBookList(query)
            LoadResult.Page(
                data = response.items.map { it.toBook() },
                prevKey = null,
                nextKey = if (response.items.isNullOrEmpty()) null else nextPageNumber + 10
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

//    return try {
//        val nextPageNumber = if (params.key == null) {
//            1
//        } else {
//            when(params){
//                is LoadParams.Append -> params.key
//                is LoadParams.Prepend -> params.key
//                else -> 1
//            }
//        }
//        val response = infraService.getMoviesByQuery(query, nextPageNumber)
//        LoadResult.Page(
//            data = response.items.map { it.toMovie() },
//            prevKey = null,
//            nextKey = if (nextPageNumber + 10 >= 1001 || response.items.isNullOrEmpty()) null else response.start + 10
//        )
//    } catch (e: Exception) {
//        LoadResult.Error(e)
//    }
}