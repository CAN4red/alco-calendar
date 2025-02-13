package com.example.alcocalendar.features.calendar.presentation.common

import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import java.time.LocalDate

data class CalendarDataState(
    val value: Map<LocalDate, CalendarSessionWithIntakes> = emptyMap()
)

fun CalendarDataState.getSessionWithIntakes(date: LocalDate): CalendarSessionWithIntakes {
    return value[date] ?: CalendarSessionWithIntakes(date)
}
