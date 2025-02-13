package com.example.alcocalendar.features.calendar.domain.model

import com.example.alcocalendar.core.domain.model.DrinkIntake
import java.time.LocalDate

data class CalendarSessionWithIntakes(
    val date: LocalDate,
    val intakes: List<DrinkIntake> = emptyList()
) {
    val isEmpty: Boolean
        get() = intakes.any { !it.isEmpty }

    val alcoUnits: Double
        get() = intakes.sumOf { it.alcoUnits }
}