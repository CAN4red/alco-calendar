package com.example.alcocalendar.features.drink_intake.domain.repository

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.repository.SharedDrinkIntakeRepository

interface DrinkIntakeRepository: SharedDrinkIntakeRepository {

    suspend fun insertDrinkIntake(drinkIntake: DrinkIntake)

    suspend fun updateDrinkIntake(drinkIntake: DrinkIntake)

    suspend fun deleteDrinkIntake(drinkIntake: DrinkIntake)
}
