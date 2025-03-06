package com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case.insert_intake

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.session_manage.drink_intake.domain.repository.DrinkIntakeRepository
import javax.inject.Inject

class SafeInsertDrinkIntakeUseCase @Inject constructor(
    private val repository: DrinkIntakeRepository
) {
    suspend operator fun invoke(drinkIntake: DrinkIntake) {
        if (drinkIntake.liters == 0.0) return

        val existingDrinkIntakes = repository.getDrinkIntakesByDate(drinkIntake.date)

        val existingDrinkIntake = existingDrinkIntakes.find() {
            it.drinkType == drinkIntake.drinkType && it.alcoStrength == drinkIntake.alcoStrength
        }

        if (existingDrinkIntake != null) {
            repository.updateDrinkIntake(existingDrinkIntake)
        } else {
            repository.insertDrinkIntake(drinkIntake)
        }
    }
}