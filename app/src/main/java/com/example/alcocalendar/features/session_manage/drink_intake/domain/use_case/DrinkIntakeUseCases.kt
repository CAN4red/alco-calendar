package com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case

import com.example.alcocalendar.core.domain.use_case.get_intakes.GetDrinkIntakesUseCase
import com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case.delete_intake.DeleteDrinkIntakeUseCase
import com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case.insert_intake.InsertDrinkIntakeUseCase
import com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case.update_intake.UpdateDrinkIntakeUseCase
import javax.inject.Inject

data class DrinkIntakeUseCases @Inject constructor(
    val getDrinkIntakesUseCase: GetDrinkIntakesUseCase,
    val insertDrinkIntakeUseCase: InsertDrinkIntakeUseCase,
    val updateDrinkIntakeUseCase: UpdateDrinkIntakeUseCase,
    val deleteDrinkIntakeUseCase: DeleteDrinkIntakeUseCase,
)
