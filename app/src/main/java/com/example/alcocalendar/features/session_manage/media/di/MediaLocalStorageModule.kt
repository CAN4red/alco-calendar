package com.example.alcocalendar.features.session_manage.media.di

import android.content.Context
import com.example.alcocalendar.features.session_manage.media.data.data_source.LocalImageDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaLocalStorageModule {
    @Provides
    @Singleton
    fun provideLocalImageDataSource(@ApplicationContext context: Context): LocalImageDataSource {
        return LocalImageDataSource(context)
    }
}