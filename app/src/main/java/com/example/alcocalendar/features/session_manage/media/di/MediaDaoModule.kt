package com.example.alcocalendar.features.session_manage.media.di

import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.features.session_manage.media.data.local.dao.MediaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaDaoModule {
    @Provides
    @Singleton
    fun provideMediaDao(db: DrinkingSessionDatabase): MediaDao {
        return db.mediaDao
    }
}