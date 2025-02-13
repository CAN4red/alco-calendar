package com.example.alcocalendar.features.calendar.di

import com.example.alcocalendar.features.calendar.domain.repository.CalendarRepository
import com.example.alcocalendar.features.calendar.domain.use_case.load_sessions_with_intakes.GetSessionsWithIntakesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CalendarUseCaseModule {
    @Provides
    fun provideLoadSessionsWithIntakesUseCase(
        repository: CalendarRepository
    ): GetSessionsWithIntakesUseCase {
        return GetSessionsWithIntakesUseCase(repository)
    }
}