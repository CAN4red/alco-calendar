package com.example.alcocalendar.features.drink_intake.di

import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.features.drink_intake.data.local.dao.DrinkIntakeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DrinkIntakeDaoModule {
    @Provides
    fun provideDrinkIntakeDao(db: DrinkingSessionDatabase): DrinkIntakeDao {
        return db.drinkIntakeDao
    }
}