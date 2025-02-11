package com.example.alcocalendar.core.di

import com.example.alcocalendar.core.domain.repository.SharedDrinkIntakeRepository
import com.example.alcocalendar.core.domain.use_case.get_intakes.GetDrinkIntakesUseCase
import com.example.alcocalendar.core.domain.use_case.get_sessions_with_intakes.GetDrinkingSessionsWithDrinkIntakesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedDrinkIntakeUseCaseModule {
    @Provides
    fun provideGetDrinkIntakesUseCase(
        sharedRepository: SharedDrinkIntakeRepository
    ): GetDrinkIntakesUseCase {
        return GetDrinkIntakesUseCase(sharedRepository)
    }

    @Provides
    fun provideGetDrinkingSessionsWithDrinkIntakesUseCase(
        sharedRepository: SharedDrinkIntakeRepository
    ): GetDrinkingSessionsWithDrinkIntakesUseCase {
        return GetDrinkingSessionsWithDrinkIntakesUseCase(sharedRepository)
    }
}