package com.example.alcocalendar.features.session_manage.drink_intake.di

import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.features.session_manage.drink_intake.data.local.dao.DrinkIntakeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkIntakeDaoModule {
    @Provides
    @Singleton
    fun provideDrinkIntakeDao(db: DrinkingSessionDatabase): DrinkIntakeDao {
        return db.drinkIntakeDao
    }
}