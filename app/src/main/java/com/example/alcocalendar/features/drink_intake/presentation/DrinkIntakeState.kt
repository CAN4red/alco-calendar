package com.example.alcocalendar.features.drink_intake.presentation

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkType
import java.time.LocalDate

data class DrinkIntakeState(
    val date: LocalDate = LocalDate.now(),
    val intakes: List<DrinkIntake> = emptyList(),
    val fillingIntake: DrinkIntake? = null,
    val expandedDrinkType: Class<out DrinkType>? = null,
)
