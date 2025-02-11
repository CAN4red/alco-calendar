package com.example.alcocalendar.features.drink_intake.domain.use_case.update_intake

import com.example.alcocalendar.core.data.local.entities.DrinkIntake
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import javax.inject.Inject

class UpdateDrinkIntakeUseCase @Inject constructor(
    private val repository: DrinkIntakeRepository
) {
    suspend operator fun invoke(drinkIntake: DrinkIntake) {
        repository.updateDrinkIntake(drinkIntake)
    }
}