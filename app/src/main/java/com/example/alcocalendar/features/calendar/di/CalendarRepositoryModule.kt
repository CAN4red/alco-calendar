package com.example.alcocalendar.features.calendar.di

import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.calendar.data.repository.CalendarMonthRepositoryImpl
import com.example.alcocalendar.features.calendar.data.repository.CalendarYearRepositoryImpl
import com.example.alcocalendar.features.calendar.domain.repository.CalendarMonthRepository
import com.example.alcocalendar.features.calendar.domain.repository.CalendarYearRepository
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
    fun provideCalendarMonthRepository(dao: CalendarDao): CalendarMonthRepository {
        return CalendarMonthRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideCalendarYearRepository(dao: CalendarDao): CalendarYearRepository {
        return CalendarYearRepositoryImpl(dao)
    }

}