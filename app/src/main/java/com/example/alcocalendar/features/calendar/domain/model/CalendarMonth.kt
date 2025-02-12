package com.example.alcocalendar.features.calendar.domain.model

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkingSession

data class CalendarMonth(
    val monthSessionsWithIntakes: Map<DrinkingSession, List<DrinkIntake>>
)