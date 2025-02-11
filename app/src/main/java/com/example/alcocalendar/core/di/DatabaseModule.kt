package com.example.alcocalendar.core.di

import android.content.Context
import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDrinkingSessionDatabase(@ApplicationContext context: Context): DrinkingSessionDatabase {
        return DrinkingSessionDatabase.getInstance(context)
    }

    @Provides
    fun provideDrinkingSessionDao(db: DrinkingSessionDatabase): DrinkingSessionDao {
        return db.drinkingSessionDao
    }
}
