package com.example.alcocalendar.features.calendar.presentation

import java.time.LocalDate
import java.time.Month

sealed interface CalendarEvent {
    data class UpdateCurrentYearMonth(val year: Int? = null, val month: Month? = null) : CalendarEvent

    data class InitializeSession(val sessionDate: LocalDate) : CalendarEvent
}