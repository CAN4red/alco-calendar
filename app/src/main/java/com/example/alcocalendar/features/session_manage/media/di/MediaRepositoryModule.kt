package com.example.alcocalendar.features.session_manage.media.di

import android.content.Context
import com.example.alcocalendar.features.session_manage.media.data.data_source.LocalImageDataSource
import com.example.alcocalendar.features.session_manage.media.data.local.dao.MediaDao
import com.example.alcocalendar.features.session_manage.media.data.repository.ImageRepositoryImpl
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaRepositoryModule {
    @Provides
    @Singleton
    fun provideImageRepository(
        localImageDataSource: LocalImageDataSource,
        mediaDao: MediaDao,
        @ApplicationContext context: Context
    ): ImageRepository {
        return ImageRepositoryImpl(localImageDataSource, mediaDao, context)
    }
}