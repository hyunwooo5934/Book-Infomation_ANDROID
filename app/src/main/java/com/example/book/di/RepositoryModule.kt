package com.example.book.di

import com.example.data.api.BookService
import com.example.data.db.WordDao
import com.example.data.repository.LocalDataRepositoryImpl
import com.example.data.repository.MainRepositoryImpl
import com.example.domain.repository.LocalDataRepository
import com.example.domain.repository.MainRepository
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
    ) : MainRepository {
        return MainRepositoryImpl(bookService)
    }

    @Singleton
    @Provides
    fun provideLocalDataRepository(
        wordDao: WordDao
    ) : LocalDataRepository {
        return LocalDataRepositoryImpl(wordDao)
    }


}