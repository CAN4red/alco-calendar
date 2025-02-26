package com.example.alcocalendar.features.drink_intake.presentation

import com.example.alcocalendar.core.domain.model.DrinkType

sealed interface DrinkIntakeEvent {
    data class SetFillingDrinkIntake(val drinkType: DrinkType, val alcoStrength: Double) :
        DrinkIntakeEvent

    data class SetFillingDrinkIntakeAlcoStrength(val alcoStrength: Double) : DrinkIntakeEvent
    data class SetFillingDrinkIntakeLiters(val liters: Double) : DrinkIntakeEvent
    data object DropFillingDrinkIntake : DrinkIntakeEvent

    data object InsertDrinkIntake : DrinkIntakeEvent
    data object UpdateDrinkIntake : DrinkIntakeEvent
    data object DeleteDrinkIntake : DrinkIntakeEvent

    data class SetExpandedIntake(val drinkType: Class<out DrinkType>?) : DrinkIntakeEvent
}
