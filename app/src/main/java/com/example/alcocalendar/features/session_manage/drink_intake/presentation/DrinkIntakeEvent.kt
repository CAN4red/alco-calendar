package com.example.alcocalendar.features.session_manage.drink_intake.presentation

import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.FillingType

sealed interface DrinkIntakeEvent {
    data class SetFillingDrinkIntake(
        val drinkType: DrinkType,
        val alcoStrength: Double,
        val liters: Double = 0.0,
        val fillingType: FillingType,
    ) : DrinkIntakeEvent

    data class SetFillingDrinkIntakeAlcoStrength(val alcoStrength: Double, ) : DrinkIntakeEvent
    data class SetFillingDrinkIntakeLiters(val liters: Double) : DrinkIntakeEvent
    data object DropFillingDrinkIntake : DrinkIntakeEvent

    data object InsertUpdateDrinkIntake : DrinkIntakeEvent
    data object DeleteDrinkIntake : DrinkIntakeEvent

    data class SetExpandedIntakeType(val drinkType: Class<out DrinkType>?) : DrinkIntakeEvent
}
