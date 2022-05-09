package com.junwooyeom.bookapplication.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun providesBookInfraService(retrofit: Retrofit): BookInfraService = retrofit.create(BookInfraService::class.java)

    private companion object {
        const val BASE_URL = "https://www.googleapis.com/books/v1/"
    }
}
