package com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case.insert_intake

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.session_manage.drink_intake.domain.repository.DrinkIntakeRepository
import javax.inject.Inject

class InsertDrinkIntakeUseCase @Inject constructor(
    private val repository: DrinkIntakeRepository
) {
    suspend operator fun invoke(drinkIntake: DrinkIntake) {
        if (drinkIntake.liters == 0.0) return

        repository.insertDrinkIntake(drinkIntake)
    }
}