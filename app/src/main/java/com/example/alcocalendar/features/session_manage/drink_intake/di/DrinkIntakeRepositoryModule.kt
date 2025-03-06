package com.example.alcocalendar.features.session_manage.drink_intake.di

import com.example.alcocalendar.features.session_manage.drink_intake.data.local.dao.DrinkIntakeDao
import com.example.alcocalendar.features.session_manage.drink_intake.data.repository.DrinkIntakeRepositoryImpl
import com.example.alcocalendar.features.session_manage.drink_intake.domain.repository.DrinkIntakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkIntakeRepositoryModule {
    @Provides
    @Singleton
    fun provideDrinkIntakeRepository(dao: DrinkIntakeDao): DrinkIntakeRepository {
        return DrinkIntakeRepositoryImpl(dao)
    }
}