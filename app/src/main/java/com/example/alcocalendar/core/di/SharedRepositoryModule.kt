package com.example.alcocalendar.core.di

import com.example.alcocalendar.core.domain.repository.SharedDrinkIntakeRepository
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedRepositoryModule {
    @Provides
    fun provideSharedDrinkIntakeRepository(
        repository: DrinkIntakeRepository
    ): SharedDrinkIntakeRepository {
        return repository
    }
}