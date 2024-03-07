package com.example.book.module

import com.example.data.api.BookService
import com.example.data.db.WordDao
import com.example.data.repository.LocalDataRepositoryImpl
import com.example.data.repository.SearchRepositoryImpl
import com.example.data.repository.bestSellerRepositoryImpl
import com.example.domain.repository.LocalDataRepository
import com.example.domain.repository.SearchRepository
import com.example.domain.repository.bestSellerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        bookService: BookService
    ) : SearchRepository {
        return SearchRepositoryImpl(bookService)
    }

    @Singleton
    @Provides
    fun provideLocalDataRepository(
        wordDao: WordDao
    ) : LocalDataRepository {
        return LocalDataRepositoryImpl(wordDao)
    }

    @Singleton
    @Provides
    fun provideBestSellerRepoitory() : bestSellerRepository {
        return bestSellerRepositoryImpl()
    }


}