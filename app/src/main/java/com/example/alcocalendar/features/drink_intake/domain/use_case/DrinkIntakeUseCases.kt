package com.example.alcocalendar.features.drink_intake.domain.use_case

import com.example.alcocalendar.core.domain.use_case.get_intakes.GetDrinkIntakesUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.delete_intake.DeleteDrinkIntakeByIdUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.insert_intake.SafeInsertDrinkIntakeUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.update_intake.UpdateDrinkIntakeUseCase

data class DrinkIntakeUseCases(
    val getDrinkIntakesUseCase: GetDrinkIntakesUseCase,
    val insertDrinkIntakeUseCase: SafeInsertDrinkIntakeUseCase,
    val updateDrinkIntakeUseCase: UpdateDrinkIntakeUseCase,
    val deleteDrinkIntakeByIdUseCase: DeleteDrinkIntakeByIdUseCase,
)
