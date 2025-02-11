package com.example.alcocalendar.features.drink_intake.domain.use_case.delete_intake

import com.example.alcocalendar.features.drink_intake.domain.repository.DrinkIntakeRepository
import javax.inject.Inject

class DeleteDrinkIntakeByIdUseCase @Inject constructor(
    private val repository: DrinkIntakeRepository
) {
    suspend operator fun invoke(drinkIntakeId: Int) {
        repository.deleteDrinkIntakeById(drinkIntakeId)
    }
}