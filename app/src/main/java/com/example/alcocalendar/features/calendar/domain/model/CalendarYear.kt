package com.example.alcocalendar.features.calendar.domain.model

import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkingSession
import java.time.Year

data class CalendarYear(
    val yearSessionsWithIntakes: Map<DrinkingSession, List<DrinkIntake>>
)