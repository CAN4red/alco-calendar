package com.example.alcocalendar.features.calendar.di

import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CalendarDaoModule {
    @Provides
    @Singleton
    fun provideCalendarDao(db: DrinkingSessionDatabase): CalendarDao {
        return db.calendarDao
    }
}