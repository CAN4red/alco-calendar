package com.example.alcocalendar.core.di

import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.repository.DrinkingSessionRepositoryImpl
import com.example.alcocalendar.core.domain.repository.DrinkingSessionRepository
import com.example.alcocalendar.core.domain.repository.SharedDrinkIntakeRepository
import com.example.alcocalendar.features.session_manage.drink_intake.domain.repository.DrinkIntakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedRepositoryModule {
    @Provides
    @Singleton
    fun provideDrinkingSessionRepository(dao: DrinkingSessionDao): DrinkingSessionRepository {
        return DrinkingSessionRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideSharedDrinkIntakeRepository(
        repository: DrinkIntakeRepository
    ): SharedDrinkIntakeRepository {
        return repository
    }
}