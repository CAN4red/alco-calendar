package com.example.alcocalendar.features.drink_intake.di

import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.features.drink_intake.data.local.repository.DrinkIntakeRepositoryImpl
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideDrinkIntakeRepository(dao: DrinkIntakeDao): DrinkIntakeRepository {
        return DrinkIntakeRepositoryImpl(dao)
    }
}