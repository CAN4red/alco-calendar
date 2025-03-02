package com.example.alcocalendar.core.domain.model

import java.time.LocalDate

data class DrinkIntake(
    val date: LocalDate,
    val drinkType: DrinkType,
    val liters: Double = 0.0,
    val alcoStrength: Double = drinkType.defaultAlcoStrength,
) {
    val isEmpty: Boolean
        get() = (liters == 0.0)

    val alcoUnits: Double
        get() = liters * alcoStrength * ETHANOL_MASS

    companion object {
        private const val ETHANOL_MASS = 0.789
    }
}
