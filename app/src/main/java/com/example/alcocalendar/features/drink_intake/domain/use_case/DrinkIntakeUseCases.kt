package com.example.alcocalendar.features.drink_intake.domain.use_case

import com.example.alcocalendar.core.domain.use_case.get_intakes.GetDrinkIntakesUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.delete_intake.DeleteDrinkIntakeUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.insert_intake.SafeInsertDrinkIntakeUseCase
import com.example.alcocalendar.features.drink_intake.domain.use_case.update_intake.UpdateDrinkIntakeUseCase
import javax.inject.Inject

data class DrinkIntakeUseCases @Inject constructor(
    val getDrinkIntakesUseCase: GetDrinkIntakesUseCase,
    val insertDrinkIntakeUseCase: SafeInsertDrinkIntakeUseCase,
    val updateDrinkIntakeUseCase: UpdateDrinkIntakeUseCase,
    val deleteDrinkIntakeUseCase: DeleteDrinkIntakeUseCase,
)
