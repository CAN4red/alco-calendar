package com.example.alcocalendar.features.calendar.presentation.common

import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import java.time.LocalDate

data class CalendarState(
    val intakesData: Map<LocalDate, CalendarSessionWithIntakes> = emptyMap()
)

fun CalendarState.getSessionWithIntakes(date: LocalDate): CalendarSessionWithIntakes {
    return intakesData[date] ?: CalendarSessionWithIntakes(date)
}
