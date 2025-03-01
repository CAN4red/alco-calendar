package com.example.alcocalendar.features.calendar.di

import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.calendar.data.repository.CalendarRepositoryImpl
import com.example.alcocalendar.features.calendar.domain.repository.CalendarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CalendarRepositoryModule {
    @Provides
    @Singleton
    fun provideCalendarRepository(
        calendarDao: CalendarDao,
        sessionDao: DrinkingSessionDao
    ): CalendarRepository {
        return CalendarRepositoryImpl(calendarDao, sessionDao)
    }
}
