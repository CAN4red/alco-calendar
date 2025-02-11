package com.example.alcocalendar.features.drink_intake.di

import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import com.example.alcocalendar.features.drink_intake.domain.use_case.delete_intake.DeleteDrinkIntakeByIdUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.insert_intake.SafeInsertDrinkIntakeUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.update_intake.UpdateDrinkIntakeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DrinkIntakeUseCaseModule {
    @Provides
    fun provideSafeInsertDrinkIntakeUseCase(
        repository: DrinkIntakeRepository
    ): SafeInsertDrinkIntakeUseCase {
        return SafeInsertDrinkIntakeUseCase(repository)
    }

    @Provides
    fun provideUpdateDrinkIntakeUseCase(
        repository: DrinkIntakeRepository
    ): UpdateDrinkIntakeUseCase {
        return UpdateDrinkIntakeUseCase(repository)
    }

    @Provides
    fun provideDeleteDrinkIntakeUseCase(
        repository: DrinkIntakeRepository
    ): DeleteDrinkIntakeByIdUseCase {
        return DeleteDrinkIntakeByIdUseCase(repository)
    }
}