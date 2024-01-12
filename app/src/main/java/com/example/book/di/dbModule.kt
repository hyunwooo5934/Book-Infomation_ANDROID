package com.example.book.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.WordDao
import com.example.data.db.appDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object dbModule {

    @Provides
    @Singleton
    fun provideappDatabase(@ApplicationContext context: Context) : appDatabase =
        Room.databaseBuilder(context, appDatabase::class.java, "book_test").build()


    @Provides
    @Singleton
    fun provideWordDao(appDb: appDatabase) : WordDao = appDb.WordDao()


}