package com.example.alcocalendar.features.calendar.presentation.common

import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import java.time.LocalDate
import java.time.YearMonth

data class SharedCalendarState(
    val intakesData: Map<LocalDate, CalendarSessionWithIntakes> = emptyMap(),
    val currentYearMonth: YearMonth = YearMonth.now(),
)

fun SharedCalendarState.getSessionWithIntakes(date: LocalDate): CalendarSessionWithIntakes {
    return intakesData[date] ?: CalendarSessionWithIntakes(date)
}
