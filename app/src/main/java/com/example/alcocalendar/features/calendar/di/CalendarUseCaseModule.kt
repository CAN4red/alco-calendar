package com.example.alcocalendar.features.calendar.di

import com.example.alcocalendar.features.calendar.domain.repository.CalendarMonthRepository
import com.example.alcocalendar.features.calendar.domain.repository.CalendarYearRepository
import com.example.alcocalendar.features.calendar.domain.use_case.get_calendar_month.GetCalendarMonthUseCase
import com.example.alcocalendar.features.calendar.domain.use_case.get_calendar_year.GetCalendarYearUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CalendarUseCaseModule {
    @Provides
    fun provideGetCalendarMonthUseCase(repository: CalendarMonthRepository): GetCalendarMonthUseCase {
        return GetCalendarMonthUseCase(repository)
    }

    @Provides
    fun provideGetCalendarYearUseCase(repository: CalendarYearRepository): GetCalendarYearUseCase {
        return GetCalendarYearUseCase(repository)
    }
}