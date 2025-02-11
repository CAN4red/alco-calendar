package com.example.alcocalendar.features.drink_intake.domain.use_case.insert_intake

import com.example.alcocalendar.core.data.local.entities.DrinkIntake
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import javax.inject.Inject

class SafeInsertDrinkIntakeUseCase @Inject constructor(
    private val repository: DrinkIntakeRepository
) {
    suspend operator fun invoke(drinkIntake: DrinkIntake) {
        val existingDrinkIntakes = repository.getDrinkIntakesByDate(drinkIntake.date)

        val existingDrinkIntake = existingDrinkIntakes.find() {
            it.drinkType == drinkIntake.drinkType && it.alcoStrength == drinkIntake.alcoStrength
        }

        if (existingDrinkIntake != null) {
            val updatedDrinkIntake =
                drinkIntake.copy(drinkIntakeId = existingDrinkIntake.drinkIntakeId)
            repository.updateDrinkIntake(updatedDrinkIntake)
        } else {
            repository.insertDrinkIntake(drinkIntake)
        }
    }
}