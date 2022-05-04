package com.junwooyeom.bookapplication

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataLayerModule {

    @Provides
    @Singleton
    fun providesBookRepository(
        infraService: BookInfraService
    ): BookRepository = BookRepositoryImpl(infraService)
}
