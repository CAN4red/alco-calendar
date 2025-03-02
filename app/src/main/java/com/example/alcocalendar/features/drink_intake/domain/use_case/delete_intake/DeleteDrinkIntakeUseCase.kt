package com.example.alcocalendar.features.drink_intake.domain.use_case.delete_intake

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import javax.inject.Inject

class DeleteDrinkIntakeUseCase @Inject constructor(
    private val repository: DrinkIntakeRepository
) {
    suspend operator fun invoke(drinkIntake: DrinkIntake) {
        repository.deleteDrinkIntake(drinkIntake)
    }
}